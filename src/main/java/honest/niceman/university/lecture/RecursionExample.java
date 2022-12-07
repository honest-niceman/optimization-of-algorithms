package honest.niceman.university.lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RecursionExample {
    public static class ExpressionParser {
        public static void main(String[] args) {
            System.out.println(parseExpression("14+(10/2-(3+5)/(7-3))*9", new AtomicInteger(0), 0));
            System.out.println(parseExpression("14+(10/2-(3+5)/(7-3))*9"));
        }

        private static double parseExpression(String s, AtomicInteger index, int brackets) {
            List<ExpressionToken> tokens = new ArrayList<>();
            char c = ' ';
            while (index.get() < s.length() && (c = s.charAt(index.get())) != ')') {
                if (tokens.size() % 2 == 1) {
                    if (c == '+' || c == '-' || c == '*' || c == '/') {
                        tokens.add(new ExpressionToken(c));
                        index.getAndIncrement();
                        continue;
                    }
                }

                if (c == '(') {
                    index.incrementAndGet();
                    tokens.add(new ExpressionToken(parseExpression(s, index, brackets + 1)));
                } else {
                    String number = getNumber(s, index);
                    tokens.add(new ExpressionToken(Double.parseDouble(number)));
                }
            }

            if (brackets > 0 && c != ')' || c == ')' && brackets == 0)
                throw new IllegalArgumentException("Wrong expression to parse: " + s);
            index.incrementAndGet();

            return calculateResult(tokens);
        }

        private static double parseExpression(String s) {
            ExpressionToken token = new ExpressionToken(0.0);
            token.setTokens(new LinkedList<>());

            AtomicInteger index = new AtomicInteger(0);
            int brackets = 0;

            while (index.get() < s.length()) {
                char c = s.charAt(index.get());
                if (token.getTokens().size() % 2 == 1) {
                    if (c == '+' || c == '-' || c == '*' || c == '/') {
                        token.getTokens().add(new ExpressionToken(c));
                        index.getAndIncrement();
                        continue;
                    }
                }

                if (c == '(') {
                    index.incrementAndGet();
                    brackets++;

                    ExpressionToken child = new ExpressionToken(0.0);
                    child.setTokens(new LinkedList<>());
                    token.getTokens().add(child);
                    child.parent = token;
                    token = child;
                } else if (c == ')') {
                    brackets--;
                    if (brackets < 0)
                        throw new IllegalArgumentException("Wrong expression to parse: " + s);

                    index.incrementAndGet();
                    token.value = calculateResult(token.getTokens());
                    token.setTokens(null);
                    token = token.parent;
                } else {
                    String number = getNumber(s, index);
                    token.getTokens().add(new ExpressionToken(Double.parseDouble(number)));
                }
            }

            return calculateResult(token.getTokens());
        }
        private static double calculateResult(List<ExpressionToken> tokens) {
            List<ExpressionToken> second = new ArrayList<>();
            Boolean calculation = null;
            for (ExpressionToken token : tokens) {
                if (calculation != null) {
                    ExpressionToken last = second.get(second.size() - 1);
                    last.value = calculation ? last.value * token.value : last.value / token.value;
                    calculation = null;
                    continue;
                }
                if (token.isValue || token.operation == '+' || token.operation == '-') {
                    second.add(token);
                } else {
                    calculation = token.operation == '*';
                }
            }

            Double result = null;
            for (ExpressionToken token : second) {
                if (result == null) {
                    result = token.value;
                } else {
                    if (token.isValue) {
                        result = calculation ? result + token.value : result - token.value;
                    } else {
                        calculation = token.operation == '+';
                    }
                }
            }

            return result;
        }

        private static String getNumber(String s, AtomicInteger index) {
            StringBuilder result = new StringBuilder();
            char c;
            while (index.get() < s.length() && (c = s.charAt(index.get())) >= '0' && c <= '9') {
                index.getAndIncrement();
                result.append(c);
            }
            return result.toString();
        }

        private static class ExpressionToken {
            private double value;
            private char operation;
            private boolean isValue;
            private List<ExpressionToken> tokens;
            private ExpressionToken parent;

            private ExpressionToken(double value) {
                this.value = value;
                isValue = true;
            }

            private ExpressionToken(char operation) {
                this.operation = operation;
                isValue = false;
            }

            public List<ExpressionToken> getTokens() {
                return tokens;
            }

            public void setTokens(List<ExpressionToken> tokens) {
                this.tokens = tokens;
            }
        }
    }
}
