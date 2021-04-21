import icons.*;

public class IconFactory {
    /**
     * Author: Srikar,
     * Desc: Returns the icon object based on the string type on which it is called.
     */
    public IconMain getIconObject(String iconType, WorkingPanel tab) {
        IconMain icon = null;
        if (iconType.equals("|-")) {
            icon = new InputBarsIcon();
        } else if (iconType.equals("-|")) {
            icon = new OutputBarsIcon();
        } else if (iconType.equals(")") && !tab.isCloseParenthesis) {
            icon = new CloseParenthesisIcon();
            LeftPanel.disableButtons(iconType);
        } else if (iconType.equals(">")) {
            icon = new GreaterThanIcon();
        } else if (iconType.equals("-")) {
            icon = new HyphenIcon();
        } else if (iconType.equals("<")) {
            icon = new LessThanIcon();
        } else if (iconType.equals("@")) {
            icon = new LoopIcon();
        } else if (iconType.equals("(") && !tab.isOpenParenthesis) {
            icon = new OpenParenthesisIcon();
            LeftPanel.disableButtons(iconType);
        }
        return icon;
    }

}
