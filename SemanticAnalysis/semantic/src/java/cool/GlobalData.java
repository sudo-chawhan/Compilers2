package cool;
import java.util.*;
public class GlobalData{

  // Type constants
    public static class Const {
        public static final String ROOT_TYPE = "Object";
        public static final String IO_TYPE = "IO";
        public static final String INT_TYPE = "Int";
        public static final String BOOL_TYPE = "Bool";
        public static final String STRING_TYPE = "String";
        public static final String MAIN_TYPE = "Main";
        public static final boolean is_standard(String name){
            if(name.equals(IO_TYPE)) return true;
            if(name.equals(STRING_TYPE)) return true;
            if(name.equals(BOOL_TYPE)) return true;
            if(name.equals(INT_TYPE)) return true;
            return false;
        }
        public static final boolean is_standard_class_name(String name){
            if(name.equals(ROOT_TYPE)) return true;
            if(name.equals(IO_TYPE)) return true;
            if(name.equals(STRING_TYPE)) return true;
            if(name.equals(BOOL_TYPE)) return true;
            if(name.equals(INT_TYPE)) return true;
            return false;
        }
        public static final boolean is_inheritable(String name){
            if(name.equals(MAIN_TYPE)) return false;
            if(name.equals(STRING_TYPE)) return false;
            if(name.equals(BOOL_TYPE)) return false;
            if(name.equals(INT_TYPE)) return false;
            return true;
        }
    }

  public static AST.class_ ROOT_CLASS = new AST.class_(Const.ROOT_TYPE, "", Const.ROOT_TYPE, new ArrayList<AST.feature>(), 0);
  public static AST.class_ IO_CLASS   = new AST.class_(Const.IO_TYPE, "", Const.ROOT_TYPE, new ArrayList<AST.feature>(), 0);
  public static AST.class_ INT_CLASS = new AST.class_(Const.INT_TYPE, "", Const.ROOT_TYPE, new ArrayList<AST.feature>(), 0);
  public static AST.class_ BOOL_CLASS = new AST.class_(Const.BOOL_TYPE, "", Const.ROOT_TYPE, new ArrayList<AST.feature>(), 0);
  public static AST.class_ STRING_CLASS = new AST.class_(Const.STRING_TYPE, "", Const.ROOT_TYPE, new ArrayList<AST.feature>(), 0);


  // ClassTable - maps class name to class parent
  public static HashMap<String, String> classTable;
  // variable name -> variable return type
  public static ScopeTable<String> attrScopeTable;
  // function name -> FunctionTypeMangledName
  public static ScopeTable<String> methodScopeTable;
  // functionClassMangledName -> function return type
  public static HashMap<String, String> methodReturnTable;

  public static InheritanceGraph inheritanceGraph;
  public static String filename;
  public static String currentClass;
  //get mangled name of a function with classname and parameters
  public static String mangledNameWithClass(String classname, AST.method m)
  {
    StringBuilder mangledName = new StringBuilder();
    mangledName.append(classname).append("$");
    mangledName.append(m.name).append("$");
    mangledName.append("_NP").append(m.formals.size()).append("$");
    if(m.formals.size() != 0)
    {
      for(AST.formal f : m.formals)
      {
        mangledName.append(f.typeid).append("$");
      }
    }
    return mangledName.toString();
  }

  //get mangled name without classname and with parameters and its type
  public static String mangledNameWithType(AST.method m)
  {
    StringBuilder mangledName = new StringBuilder();
    mangledName.append(m.typeid).append("$");
    mangledName.append(m.name).append("$");
    mangledName.append("_NP").append(m.formals.size()).append("$");
    if(m.formals.size() != 0)
    {
      for(AST.formal f : m.formals)
      {
        mangledName.append(f.typeid).append("$");
      }
    }
    return mangledName.toString();
  }

  public static String mangledNameWithExpr(String cl,String name,List<AST.expression> elist)
  {
    StringBuilder mangledName = new StringBuilder();
    mangledName.append(cl).append("$");
    mangledName.append(name).append("$");
    mangledName.append("_NP").append(elist.size()).append("$");
    if(elist.size() != 0)
    {
      for(AST.expression e : elist)
      {
        mangledName.append(e.type).append("$");
      }
    }
    return mangledName.toString();
  }

  //to check if a method has arguments.
  public static boolean hasArguments(String name)
  {
    if(name.contains("_NP0"))
      return false;
    return true;
  }
  // gives error message to the user
  public static void GiveError(String error,int lineNo){
    System.out.println("Error: at line no. " + Integer.toString(lineNo) + " : " + error);
  }
}
