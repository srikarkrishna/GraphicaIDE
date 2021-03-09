package icons;

import interfaces.Icon;

public class IconBase {
    public Icons getIconObject(String iconType){
        Icons icon = null;
        if (iconType.equals("||")) {
          icon =  new BarsIcon();
        } else if (iconType.equals(")")) {
            icon =  new CloseParenthesisIcon();
        } else if (iconType.equals(">")) {
            icon =  new GreaterThanIcon();
        } else if (iconType.equals("-")) {
            icon =  new HyphenIcon();
        } else if (iconType.equals("<")) {
            icon =  new LessThanIcon();
        } else if (iconType.equals("@")) {
            icon =  new LoopIcon();
        } else if (iconType.equals("C")) {
            icon =  new OpenParenthesisIcon();
        }
        return icon;
    }
}
