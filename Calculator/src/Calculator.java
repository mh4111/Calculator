import java.util.Scanner;

public class Calculator {
   public static void main(String[] args) {
      int select = 0;
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("1. 계산하기  4. 프로그램 종료");
         System.out.print("메뉴 선택 >> ");

         select = sc.nextInt();

         if (select == 1) {
            calculate(sc); // calculate 메서드 호출
         } else if (select == 4) {
            System.out.println("프로그램을 종료합니다.");
            break;
         } else {
            System.out.println("다시 선택해주세요");
         }
      } // while end

      sc.close();
   } // main end

   private static void calculate(Scanner sc) {
      String exp;
      double result;

      System.out.print("식을 입력하세요 >> ");
      sc.nextLine();

      exp = sc.nextLine().replaceAll("\\s+", ""); // 입력된 식에서 공백 제거

      result = calculateExpression(exp);

      System.out.println("결과: " + result);
   } // calculate end

   private static double calculateExpression(String exp) {
      double result = 0.0;
      char operator = '+';
      double num = 0.0;

      for (int i = 0; i < exp.length(); i++) {
         char ch = exp.charAt(i); //수식의 각 문자를 추출

         if (Character.isDigit(ch)) {  //추출한 무자가 숫자인 경우
            num = num * 10 + (ch - '0'); //숫자누적
         }

         if (!Character.isDigit(ch) || i == exp.length() - 1) {
            switch (operator) {
            case '+':
               result += num;
               break;
            case '-':
               result -= num;
               break;
            case '*':
               result *= num;
               break;
            case '/':
               if(num!=0) {
                  result /= num;
               }else {
                  System.out.println("0으로 나눌 수 없습니다");
                  return 0.0;
               }
               break;
            }
            num = 0; //숫자 초기화
            operator = ch;
         }
      }
      return result; //최종 계산결과 반환
   } // calculateExpression end
} // Calculator class end