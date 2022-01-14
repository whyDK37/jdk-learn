package script.groovy;/*
 * Decompiled with CFR.
 */

import groovy.lang.Binding;
import groovy.lang.MetaClass;
import groovy.lang.Script;

import java.lang.ref.SoftReference;

import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

/**
 * "actionCode==null?0:actionCode"
 */
public class Script1 extends Script {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    private static /* synthetic */ SoftReference $callSiteArray;

    public Script1() {
        CallSite[] arrcallSite = Script1.$getCallSiteArray();
    }

    public Script1(Binding context) {
        super(context);
        CallSite[] arrcallSite = Script1.$getCallSiteArray();
    }

    public static void main(String... args) throws Throwable {
        CallSite[] arrcallSite = Script1.$getCallSiteArray();
        arrcallSite[0].call(InvokerHelper.class, Script1.class, args);
    }

    public Object run() {
        CallSite[] arrcallSite = Script1.$getCallSiteArray();
        try {
            return ScriptBytecodeAdapter.compareEqual(arrcallSite[1].callGroovyObjectGetProperty(this), null) ? Integer.valueOf(0) : arrcallSite[2].callGroovyObjectGetProperty(this);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (this.getClass() != Script1.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            $staticClassInfo = classInfo = ClassInfo.getClassInfo(this.getClass());
        }
        return classInfo.getMetaClass();
    }

    private static /* synthetic */ CallSite[] $getCallSiteArray() {
        CallSiteArray callSiteArray;
        if ($callSiteArray == null || (callSiteArray = (CallSiteArray) $callSiteArray.get()) == null) {
            callSiteArray = Script1.$createCallSiteArray();
            $callSiteArray = new SoftReference<CallSiteArray>(callSiteArray);
        }
        return callSiteArray.array;
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] arrstring = new String[3];
        Script1.$createCallSiteArray_1(arrstring);
        return new CallSiteArray(Script1.class, arrstring);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] arrstring) {
        arrstring[0] = "runScript";
        arrstring[1] = "actionCode";
        arrstring[2] = "actionCode";
    }
}