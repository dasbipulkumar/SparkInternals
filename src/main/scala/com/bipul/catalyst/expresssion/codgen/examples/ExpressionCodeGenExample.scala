package com.bipul.catalyst.expresssion.codgen.examples

import com.bipul.catalyst.expresssion.codgen.CodeGeneratorImpl
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.{Add, BoundReference, Literal, Multiply}
import org.apache.spark.sql.types.DoubleType

/**
  * Created by bipulk on 18/08/16.
  */
object ExpressionCodeGenExample {


  def main(args: Array[String]) {

    val mulExpression = Add(Multiply(BoundReference(0,DoubleType,true),Literal(2.0)), BoundReference(1,DoubleType,true))

    val unsafeRow = InternalRow(1.0D, 3.0D)

    println(mulExpression.eval(unsafeRow))

    println(CodeGeneratorImpl.getExecutor(mulExpression).execute(unsafeRow))

  }


}

