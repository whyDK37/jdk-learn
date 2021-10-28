package antlr.ArrayInit;

public class ShortToUnicodeString extends ArrayInitBaseListener {
    /**
     * 将 { 映射为 "
     */
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    /**
     * 将 } 映射为 "
     */
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    /**
     * 将整形数字映射为16进制字符串
     */
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        // Assumes no nested array initializers
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}