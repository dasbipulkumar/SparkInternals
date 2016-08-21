package com.bipul.catalyst.expresssion.codgen

import com.bipul.catalyst.expression.codgen.CodeGenerator
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.expressions.codegen.{CodeGenContext, GeneratedExpressionCode}
import org.codehaus.janino.ClassBodyEvaluator

/**
  * Created by bipulk on 18/8/16.
  */
object CodeGeneratorImpl {

  def getExecutor(expression: Expression): CodeGenerator = {

    implicit val codeGenContext = new CodeGenContext

    val generatedExpressionCode = expression.gen(codeGenContext)

    val classBodyEvaluator = new ClassBodyEvaluator()
    classBodyEvaluator.setClassName("com.bipul.catalyst.expression.codgen.GeneratedClass")
    classBodyEvaluator.setImplementedInterfaces(Array(classOf[CodeGenerator]))

    classBodyEvaluator.setDefaultImports(Array(classOf[InternalRow].getName))

    println("Generated Equivalent Java Code ::")

    println(generatedExpressionCode.code)

    val codeString = "public Object execute(InternalRow i) {" +
                      generatedExpressionCode.code +
                       " return "+ generatedExpressionCode.value +"; }"

    classBodyEvaluator.cook(codeString)

    classBodyEvaluator.getClazz.newInstance().asInstanceOf[CodeGenerator]

  }

}
