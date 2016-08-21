package com.bipul.catalyst.expresssion.codgen

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.{BoundReference, Literal, Multiply}
import org.apache.spark.sql.types.DoubleType

/**
  * Created by bipulk on 18/08/16.
  */
object ExpressionCodeGenExample {


  def main(args: Array[String]) {

    val mulExpression = Multiply(BoundReference(0,DoubleType,true),Literal(2.0))

    val unsafeRow = InternalRow(1.0D)

    println(mulExpression.eval(unsafeRow))

    println(CodeGeneratorImpl.getExecutor(mulExpression).execute(unsafeRow))

  }


}

