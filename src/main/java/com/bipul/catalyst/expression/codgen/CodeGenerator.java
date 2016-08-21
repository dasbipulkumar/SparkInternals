package com.bipul.catalyst.expression.codgen;

import org.apache.spark.sql.catalyst.InternalRow;

/**
 * Created by bipulk on 18/8/16.
 */
public interface CodeGenerator {

    Object execute(InternalRow i);

}
