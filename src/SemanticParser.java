import java.util.*;
import java.util.regex.*;
public class SemanticParser {
    private static String input; // 输入代码
    private static List<String> tokens; // 词法分析得到的token序列
    private static int position; // 当前解析位置
    private static String currentToken; // 当前解析的token
    // 词法分析函数，返回token序列
    private static List<String> lexer(String input) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\s*(\\{|}|\\(|\\)|;|(?:int|char|float)|(?:[a-zA-Z]+))(?:\\s*|'('.*?')')", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(2) != null) {
                result.add(matcher.group(2));
            } else {
                result.add(matcher.group(1));
            }
        }
        return result;
    }
    // 语法分析函数，返回语法树
    private static Node parse() {
        return statementList();
    }
    // 语法规则：语句列表
    private static Node statementList() {
        Node node = new Node("Statement List");
        while (currentToken != null && !currentToken.equals("}")) {
            node.addChild(statement());
        }
        return node;
    }
    // 语法规则：语句
    private static Node statement() {
        Node node;
        if (currentToken.equals("int") || currentToken.equals("char") || currentToken.equals("float")) {
            node = declaration();
        } else if (currentToken.equals("{")) {
            node = compoundStatement();
        } else {
            node = assignmentStatement();
        }
        return node;
    }
    // 语法规则：声明语句
    private static Node declaration() {
        Node node = new Node("Declaration");
        node.addChild(typeSpecifier());
        node.addChild(variable());
        currentToken = tokens.get(position++);
        return node;
    }
    // 语法规则：复合语句
    private static Node compoundStatement() {
        currentToken = tokens.get(position++);
        Node node = statementList();
        currentToken = tokens.get(position++);
        return node;
    }
    // 语法规则：赋值语句
    private static Node assignmentStatement() {
        Node node = variable();
        currentToken = tokens.get(position++); // 等号
        node.setType("Assignment Statement");
        node.addChild(expression());
        currentToken = tokens.get(position++);
        return node;
    }
    // 语法规则：表达式
    private static Node expression() {
        Node node = term();
        while (currentToken.equals("+") || currentToken.equals("-")) {
            Node opNode = new Node(currentToken);
            opNode.addChild(node);
            node = opNode;
            currentToken = tokens.get(position++);
            node.addChild(term());
        }
        return node;
    }
    // 语法规则：项
    private static Node term() {
        Node node = factor();
        while (currentToken.equals("*") || currentToken.equals("/")) {
            Node opNode = new Node(currentToken);
            opNode.addChild(node);
            node = opNode;
            currentToken = tokens.get(position++);
            node.addChild(factor());
        }
        return node;
    }
    // 语法规则：因子
    private static Node factor() {
        Node node;
        if (currentToken.equals("(")) {
            currentToken = tokens.get(position++);
            node = expression();
            currentToken = tokens.get(position++);
        } else {
            node = variable();
        }
        return node;
    }
    // 语法规则：变量
    private static Node variable() {
        Node node = new Node(currentToken, "Variable");
        currentToken = tokens.get(position++);
        return node;
    }
    // 语法规则：类型指示符
    private static Node typeSpecifier() {
        Node node = new Node(currentToken, "Type Specifier");
        currentToken = tokens.get(position++);
        return node;
    }
    // 语义分析函数，检查代码的语义是否正确
    private static void semanticAnalysis(Node node) {
        if (node.getType().equals("Variable") && !isValidVariable(node)) {
            System.out.println("错误：变量 " + node.getName() + " 未声明。");
        }
        for (Node child : node.getChildren()) {
            semanticAnalysis(child);
        }
    }
    // 检查变量是否在之前声明
    private static boolean isValidVariable(Node node) {
        // TODO: 检查变量是否在之前声明
        return true;
    }
    // 测试函数
    public static void main(String[] args) {
        // 输入代码
        input = "int main() {\n" +
                "  int i, sum = 0;\n" +
                "  for (i = 1; i <= 10; i++) {\n" +
                "    sum += i;\n" +
                "  }\n" +
                "  return sum;\n" +
                "}";
        // 词法分析
        tokens = lexer(input);
        System.out.println(tokens);
        // 语法分析
        position = 0;
        currentToken = tokens.get(position++);
        Node syntaxTree = parse();
        // 语义分析
        semanticAnalysis(syntaxTree);
        // 打印语法树
        syntaxTree.print(0);
    }
}
// 语法树节点类
class Node {
    private String name;
    private String type;
    private List<Node> children;
    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    public Node(String name, String type) {
        this.name = name;
        this.type = type;
        this.children = new ArrayList<>();
    }
    public void addChild(Node child) {
        this.children.add(child);
    }
    public List<Node> getChildren() {
        return this.children;
    }
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(this.getName() + " (" + this.getType() + ")");
        for (Node child : this.getChildren()) {
            child.print(level + 1);
        }
    }
}