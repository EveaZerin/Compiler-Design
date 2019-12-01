import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmailCompiler {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		int n = 1;
		int lines = 0;
		List<String> st;

		st = Files.readAllLines(Path.of("C:\\Users\\evea_\\Desktop\\Eclipse Codings\\CSE420Lab02\\src\\input.txt"));

		boolean valid = false;
		int state = 1;
		int email = 1;
		int website = 2;
		String str = "";
		for (int i = 1; i < st.size(); i++) {
			str = st.get(i);
			valid = false;
			// System.out.println(str);

			// String test

			if (str.startsWith("www.") && str.endsWith(".com")) { // website testing
				System.out.println("YES, 2");
			} else if (str.contains("@")) { // email testing
				for (int c = 0; c < str.length(); c++) {
					if (c == 0) {
						if (str.charAt(c) == ' ' || str.charAt(c) == '_' || str.charAt(c) == '$' || str.charAt(c) == '0'
								|| str.charAt(c) == '1' || str.charAt(c) == '2' || str.charAt(c) == '3'
								|| str.charAt(c) == '4' || str.charAt(c) == '5' || str.charAt(c) == '6'
								|| str.charAt(c) == '7' || str.charAt(c) == '8' || str.charAt(c) == '9'
								|| str.charAt(c) == '@' || str.charAt(c) == '!') {
							valid = false;
							System.out.println("NO1,");
							break;
						} else {
							valid = true;
							state++;
					//		System.out.println(state);
						}
					} else {

						int x = str.indexOf("@") + 1;
						state++;
					//	System.out.println(state);
						c = x;
						if (str.charAt(x) == 'g') {
							String hold = str.substring(x, x + 5);
					//		System.out.println(hold);
							if (hold.equals("gmail")) {
								valid = true;
								state++;
							//	System.out.println(state);
								c = x + 5;
							} else {
								System.out.println("NO2,");
								break;
							}

						} else if (str.charAt(x) == 'y') {
							String hold = str.substring(x, x + 5);
							if (hold.equals("yahoo")) {
								valid = true;
								state++;
								c = x + 5;
							} else {
								System.out.println("NO3,");
								break;
							}

						} else if (str.charAt(x) == 'h') {
							String hold = str.substring(x, x + 7);
							if (hold.equals("hotmail")) {
								valid = true;
								state++;
								c = x + 7;
							} else {
								System.out.println("NO4,");
								break;
							}
						} else if (x == 0) {
							valid = false;
							System.out.println("NO5,");
							break;
						} else {
							valid = false;
							System.out.println("NO6,");
							break;
						}

					//	System.out.println(state + "shesh state guna");

						// code here
						if (state == 4) {
							c = c++;
							String checkDot = str.substring(c, c + 4);
					//		System.out.println(checkDot);
							if (checkDot.equals(".com")) {
								c = c + 4;
								valid = true;
								System.out.println("YES,1");
								state++;
							} else {
								valid = false;
								System.out.println("NO7,");
								break;
							}
						}

						// System.out.println(state);

				/*		if (state == 5 && c == (str.length() - 1)) {
							System.out.println("Email,1");
						}  */

					}
					// System.out.println(str.charAt(c));
				}
			} else {
				System.out.println("NO8,");
			}

		}

	}

}
