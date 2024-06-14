package InterfaceGame;

public class InterfaceCreatorTool {
	final static String SETTING_ICON = "images/setting.png";
	
	public static String insertLineBreaks(String input, int lineLength) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int length = input.length();

        while (start < length) {
            int end = Math.min(start + lineLength, length);
            if (end == length) {
                result.append(input.substring(start));
                break;
            }

            // Rechercher le dernier espace avant de couper
            int lastSpace = input.lastIndexOf(' ', end);
            if (lastSpace > start) {
                result.append(input, start, lastSpace).append("<br>");
                start = lastSpace + 1;  // Sauter l'espace
            } else {
                result.append(input, start, end).append("<br>");
                start = end;
            }
        }

        return result.toString();
    }
	
	public static String stringDescriptionNodeFormat(String string) {
		string.replace("\n", "<br>");
		string = insertLineBreaks(string, 100);
		return string;
	}
	

}
