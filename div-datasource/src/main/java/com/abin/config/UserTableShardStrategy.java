package com.abin.config;


import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Intercepts(@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class,Integer.class}
))
public class UserTableShardStrategy implements Interceptor {

    private static final String logicTable = "user";
    private static final List<String> actualTable = new ArrayList();
    static {
        actualTable.add("user_00");
        actualTable.add("user_01");
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String statementId = mappedStatement.getId();
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");

        ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");;
        Object parameterObject = parameterHandler.getParameterObject();
        sql = replaceSql(logicTable, parameterObject, sql);

        metaObject.setValue("delegate.boundSql.sql", sql);
        return invocation.proceed();
    }

    private String replaceSql(String logic, Object parameterObject, String sql) {
        String actual = "";
        if (parameterObject instanceof Integer) {
            // 分表策略: 根据ID取模
            Integer index = (Integer) parameterObject % actualTable.size();
            actual = logic + "_0" + index ;
        } else {
            // 默认表
            actual = actualTable.get(0);
        }

        return replaceTableName(sql,logic,actual);
    }

    public static String replaceTableName(String sql, String oldTableName,String newTableName) {
       return sql.replaceAll("from " + oldTableName + " where","from " + newTableName + " where");
    }
}
