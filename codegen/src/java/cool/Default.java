package cool;
import java.util.*;
import java.io.PrintWriter;
public class Default{



  public static void setDefaultClassSizes(){
    GlobalData.classNameToSize.put("Object",0);
    GlobalData.classNameToSize.put("IO",0);
    GlobalData.classNameToSize.put("Int",4);
    GlobalData.classNameToSize.put("Bool",1);
    GlobalData.classNameToSize.put("String",8);
  }

  /*public static void setDefaultMethodNames(){

  }*/

  public static void visitDefaultMethods(){
    //Class: Object, Method: abort
    GlobalData.out.println("define %class.Object* " + "@" + GlobalData.mangledName(GlobalData.Const.ROOT_TYPE, "abort") + "(%class.Object* %this) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = getelementptr inbounds %class.Object, %class.Object* %this, i32 0, i32 0");
    GlobalData.out.println("%1 = load i8*, i8** %0, align 8");
    GlobalData.out.println("%2 = getelementptr inbounds [3 x i8], [3 x i8]*" + " @globalstring" + GlobalData.strConsToRegister.get("%s") + ", i32 0, i32 0");
    GlobalData.out.println("%3 = getelementptr inbounds [26 x i8], [26 x i8]*"+" @globalstring" + GlobalData.strConsToRegister.get(GlobalData.Const.ABORT)+", i32 0, i32 0");
    GlobalData.out.println("%4 = call i32 (i8*, ...) @printf(i8* %2, i8* %3)");
    GlobalData.out.println("%5 = call i32 (i8*, ...) @printf(i8* %2, i8* %1)");
    GlobalData.out.println("%6 = getelementptr inbounds [2 x i8], [2 x i8]*"+" @globalstring" + GlobalData.strConsToRegister.get("\n")+", i32 0, i32 0");
    GlobalData.out.println("%7 = call i32 (i8*, ...) @printf(i8* %2, i8* %6)");
    GlobalData.out.println("call void @exit(i32 0)");
    GlobalData.out.println("%8 = call noalias i8* @malloc(i64 0)");
    GlobalData.out.println("%9 = bitcast i8* %8 to %class.Object*");
    GlobalData.out.println("call void " + "@" + GlobalData.mangledName(GlobalData.Const.ROOT_TYPE, GlobalData.Const.ROOT_TYPE) + "(%class.Object* %9)");
    GlobalData.out.println("ret %class.Object* %9");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: Object, Method: type_name
    GlobalData.out.println("define i8* " + "@" + GlobalData.mangledName(GlobalData.Const.ROOT_TYPE, "type_name") + "(%class.Object* %this) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = getelementptr inbounds %class.Object, %class.Object* %this, i32 0, i32 0");
    GlobalData.out.println("%1 = load i8*, i8** %0, align 8");
    GlobalData.out.println("ret i8* %1");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: IO, Method: out_string
    GlobalData.out.println("define %class.IO* " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, "out_string") + "(%class.IO* %this, i8* %s) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = getelementptr inbounds [3 x i8], [3 x i8]* " + "@globalstring" + GlobalData.strConsToRegister.get("%s") + ", i32 0, i32 0");
    GlobalData.out.println("%call = call i32 (i8*, ...) @printf(i8* %0, i8* %s)");
    GlobalData.out.println("%1 = call noalias i8* @malloc(i64 8)");
    GlobalData.out.println("%2 = bitcast i8* %1 to %class.IO*");
    GlobalData.out.println("call void " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, GlobalData.Const.IO_TYPE) + "(%class.IO* %2)");
    GlobalData.out.println("ret %class.IO* %2");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: IO, Method: out_int
    GlobalData.out.println("define %class.IO* " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, "out_int") + "(%class.IO* %this, i32 %d) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = getelementptr inbounds [3 x i8], [3 x i8]* " + "@globalstring" + GlobalData.strConsToRegister.get("%d") + ", i32 0, i32 0");
    GlobalData.out.println("%call = call i32 (i8*, ...) @printf(i8* %0, i32 %d)");
    GlobalData.out.println("%1 = call noalias i8* @malloc(i64 8)");
    GlobalData.out.println("%2 = bitcast i8* %1 to %class.IO*");
    GlobalData.out.println("call void " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, GlobalData.Const.IO_TYPE) + "(%class.IO* %2)");
    GlobalData.out.println("ret %class.IO* %2");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: IO, Method: in_int
    GlobalData.out.println("define i32 " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, "in_int") + "(%class.IO* %this) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = alloca i32, align 8");
    GlobalData.out.println("%1 = getelementptr inbounds [3 x i8], [3 x i8]* " + "@globalstring" + GlobalData.strConsToRegister.get("%d") + ", i32 0, i32 0");
    GlobalData.out.println("%call = call i32 (i8*, ...) @scanf(i8* %1, i32* %0)");
    GlobalData.out.println("%2 = load i32, i32* %0, align 4");
    GlobalData.out.println("ret i32 %2");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: IO, Method: in_string
    GlobalData.out.println("define i8* " + "@" + GlobalData.mangledName(GlobalData.Const.IO_TYPE, "in_string") + "(%class.IO* %this) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = alloca i8*, align 8");
    GlobalData.out.println("%1 = getelementptr inbounds [10 x i8], [10 x i8]*" + "@globalstring" + GlobalData.strConsToRegister.get("%1024[^\n]") + ", i32 0, i32 0");
    GlobalData.out.println("%2 = load i8*, i8** %0, align 8");
    GlobalData.out.println("%call = call i32 (i8*, ...) @scanf(i8* %1, i8* %2)");
    GlobalData.out.println("%3 = load i8*, i8** %0, align 8");
    GlobalData.out.println("ret i8* %3");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: String, Method: concat
    GlobalData.out.println("define i8* " + "@" + GlobalData.mangledName(GlobalData.Const.STRING_TYPE, "concat") + "(i8* %s1, i8* %s2) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = call i64 @strlen(i8* %s1)");
    GlobalData.out.println("%1 = call i64 @strlen(i8* %s2)");
    GlobalData.out.println("%2 = add nsw i64 %0, %1");
    GlobalData.out.println("%3 = add nsw i64 %2, 1");
    GlobalData.out.println("%4 = call noalias i8* @malloc(i64 %3)");
    GlobalData.out.println("%5 = call i8* @strcpy(i8* %4, i8* %s1)");
    GlobalData.out.println("%6 = call i8* @strcat(i8* %4, i8* %s2)");
    GlobalData.out.println("ret i8* %4");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //Class: String, Method: substr
    GlobalData.out.println("define i8* " + "@" + GlobalData.mangledName(GlobalData.Const.STRING_TYPE, "substr") + "(i8* %s1, i32 %index, i32 %len) {");
    GlobalData.out.println("entry:");
    GlobalData.out.println("%0 = zext i32 %len to i64");
    GlobalData.out.println("%1 = call noalias i8* @malloc(i64 %0)");
    GlobalData.out.println("%2 = getelementptr inbounds i8, i8* %s1, i32 %index");
    GlobalData.out.println("%3 = call i8* @strncpy(i8* %1, i8* %2, i64 %0)");
    GlobalData.out.println("ret i8* %1");
    GlobalData.out.println("}");
    GlobalData.out.println();

    //method to report divide by 0 error
    GlobalData.out.println("define void @reportError0(){");
    GlobalData.out.println("entry:");
    String error = IRInstructions.addGEPInstruction(GlobalData.Const.ZERO_ERROR);
    String s = IRInstructions.addGEPInstruction("%s");
    GlobalData.out.print("%r = call i32 (i8*, ...) @printf(i8* ");
    GlobalData.out.print(s);
    GlobalData.out.print(", i8* ");
    GlobalData.out.print(error);
    GlobalData.out.println(")\nret void\n}");
    GlobalData.out.println();

    //method to report dispatch on void error
    GlobalData.out.println("define void @reportErrorVoid(){");
    GlobalData.out.println("entry:");
    error = IRInstructions.addGEPInstruction(GlobalData.Const.VOID_ERROR);
    s = IRInstructions.addGEPInstruction("%s");
    GlobalData.out.print("%r = call i32 (i8*, ...) @printf(i8* ");
    GlobalData.out.print(s);
    GlobalData.out.print(", i8* ");
    GlobalData.out.print(error);
    GlobalData.out.println(")\nret void\n}");
    GlobalData.out.println();

  }

  //add c declatarions to IR
  public static void addCdecls(){
    GlobalData.out.println("declare i32 @printf(i8*, ...)\n\n");
    GlobalData.out.println("declare i32 @scanf(i8*, ...)\n\n");
    GlobalData.out.println("declare void @exit(i32)\n\n");
    GlobalData.out.println("declare i8* @malloc(i64)\n\n");
    GlobalData.out.println("declare i64 @strlen(i8*)\n\n");
    GlobalData.out.println("declare i32 @strcmp(i8*, i8*)\n\n");
    GlobalData.out.println("declare i8* @strcat(i8*, i8*)\n\n");
    GlobalData.out.println("declare i8* @strcpy(i8*, i8*)\n\n");
    GlobalData.out.println("declare i8* @strncpy(i8*, i8*, i32)\n\n");
  }
  public static void addDefaultStrings(){
    if(!GlobalData.strConsToRegister.containsKey("%1024[^\n]")){
      GlobalData.strConsToRegister.put("%1024[^\n]", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("%d")){
      GlobalData.strConsToRegister.put("%d", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("%d\n")){
      GlobalData.strConsToRegister.put("%d\n", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("%s")){
      GlobalData.strConsToRegister.put("%s", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("\n")){
      GlobalData.strConsToRegister.put("\n", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("")){
      GlobalData.strConsToRegister.put("", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("Int")){
      GlobalData.strConsToRegister.put("Int", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("Bool")){
      GlobalData.strConsToRegister.put("Bool", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("String")){
      GlobalData.strConsToRegister.put("String", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("Object")){
      GlobalData.strConsToRegister.put("Object", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("IO")){
      GlobalData.strConsToRegister.put("IO", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey("Main")){
      GlobalData.strConsToRegister.put("Main", GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey(GlobalData.Const.ZERO_ERROR)){
      GlobalData.strConsToRegister.put(GlobalData.Const.ZERO_ERROR, GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey(GlobalData.Const.VOID_ERROR)){
      GlobalData.strConsToRegister.put(GlobalData.Const.VOID_ERROR, GlobalData.strCounter);
      GlobalData.strCounter++;
    }
    if(!GlobalData.strConsToRegister.containsKey(GlobalData.Const.ABORT)){
      GlobalData.strConsToRegister.put(GlobalData.Const.ABORT, GlobalData.strCounter);
      GlobalData.strCounter++;
    }
  }
}
