package com.bipul.catalyst.expression.codgen;

import org.apache.spark.sql.catalyst.InternalRow;


public interface CodeGenerator {

    int a = 1;

    Object execute(InternalRow i);

}
