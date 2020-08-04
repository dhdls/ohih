package Main;

import java.util.Scanner;

import Main.DTO.RegisterRequest;
import Main.service.MemberRegisterService;
import Main.service.MemeberListPrinter;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("명령어를 입력해주세요");
		String command = sc.nextLine();
		if(command.startsWith("new")) {
			// 의존객체  // denpentdency object 
			String [] arg = command.split(" ");
			if(arg.length != 5 ) { 
				printHelp();
				continue;
			}
			RegisterRequest req = new RegisterRequest();
			req.setEmail(arg[1]);
			req.setName(arg[2]);
			req.setPassword(arg[3]);
			req.setConfirmPassword(arg[4]);
			boolean bl = req.isPasswordEqualConfirmPassword();
			if(!bl) {
				System.out.println("비밀번호가 일치하지 않습니다");
				continue;
			}
			// denpendecy object
			MemberRegisterService mrs = new MemberRegisterService();
			mrs.regist(req);
		}else if(command.startsWith("change ")) {
			System.out.println("변경");
		}else if(command.equals("list")) {
			// denpendecy object
			MemeberListPrinter listPrint = new MemeberListPrinter();
			listPrint.printAll();
		}else if(command.startsWith("info ")) {
			System.out.println("변경");
		}else if(command.equals("exit")) {
			System.out.println("프로그램이 종료되었습니다");
			System.exit(0);
		}
		}
	}
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어  사용법 :");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
	}
}
