public class UC7 {
    static class CharacterPatternMap {
        private char character;
        private String[] pattern;
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }
        public char getCharacter() {
            return character;
        }
        public String[] getPattern() {
            return pattern;
        }
    }
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] maps = new CharacterPatternMap[4];
        maps[0] = new CharacterPatternMap('O', new String[]{
                " ***** ",
                "**   **",
                "**   **",
                "**   **",
                "**   **",
                "**   **",
                " ***** "
        });
        maps[1] = new CharacterPatternMap('P', new String[]{
                "****** ",
                "**   **",
                "**   **",
                "****** ",
                "**     ",
                "**     ",
                "**     "
        });
        maps[2] = new CharacterPatternMap('S', new String[]{
                " ***** ",
                "**     ",
                "**     ",
                " ***** ",
                "     **",
                "     **",
                " ***** "
        });
        maps[3] = new CharacterPatternMap(' ', new String[]{
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   "
        });
        return maps;
    }
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {

        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', maps);
    }
    public static void printMessage(String message, CharacterPatternMap[] maps) {
        int height = 7;
        for (int i = 0; i < height; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                char ch = message.charAt(j);
                String[] pattern = getCharacterPattern(ch, maps);
                line.append(pattern[i]).append("   ");
            }
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        CharacterPatternMap[] maps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, maps);
    }
}