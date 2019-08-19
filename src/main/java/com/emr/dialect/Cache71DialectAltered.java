package com.emr.dialect;

import org.hibernate.dialect.Cache71Dialect;
import org.hibernate.hql.spi.id.IdTableSupportStandardImpl;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
import org.hibernate.hql.spi.id.global.GlobalTemporaryTableBulkIdStrategy;
import org.hibernate.hql.spi.id.local.AfterUseAction;

public class Cache71DialectAltered extends Cache71Dialect {
    @Override
    public MultiTableBulkIdStrategy getDefaultMultiTableBulkIdStrategy() {
        return new GlobalTemporaryTableBulkIdStrategy(new IdTableSupportStandardImpl() {
            @Override
            public String generateIdTableName(String baseName) {
                final String name = super.generateIdTableName(baseName);
                return name.length() > 25 ? name.substring(1, 25) : name;
            }

            @Override
            public String getCreateIdTableCommand() {
                return "create global temporary table";
            }
        }, AfterUseAction.CLEAN);
    }
}