package antlr.ArrayInit;

import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * grun ArrayInit init -tokens
 */
public class ArrayInitTest {

    public static void main(String[] args) {
        ANTLRInputStream input = new ANTLRInputStream("{1,2,3}");

        //新建一个词法分析器，处理输入的CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(input);

        //新建一个词法符号的缓冲区，用于存储词法分析器将生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 新建一个语法分析器，处理词法符号缓冲区中的内容
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();//针对init规则，开始语法分析
        System.out.println(tree.toStringTree(parser));//用LISP风格打印生成的树
        ParseTreeWalker walker = new ParseTreeWalker();		//创建分析树的遍历器
        walker.walk(new ShortToUnicodeString(), tree);		//遍历语法分析树，触发监听器的回调函数完成转换
    }


}
