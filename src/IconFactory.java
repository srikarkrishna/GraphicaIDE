import icons.*;
public class IconFactory {
    /*************************************************************************************
     *  - Method Name: getIconObject()
     *  - Input Parameters : String iconType
     *  - Return Type :Icons
     *  - Author : Srikar
     *  - Creation Date : 03/07/2021
     *  - Desc: Returns the icon object based on the string type on which it is called.
     ***************************************************************************************/
    public IconMain getIconObject(String iconType, WorkingPanel tab){
        IconMain icon = null;
        if (iconType.equals("|-")) {
          icon =  new BarsIcon();
        } else if (iconType.equals("-|")) {
            icon =  new OutputBarsIcon();
        } else if (iconType.equals(")") && !tab.isCloseParenthesis) {
            icon =  new CloseParenthesisIcon();
            LeftPanel.disableButtons(iconType);
        } else if (iconType.equals(">")) {
            icon =  new GreaterThanIcon();
        } else if (iconType.equals("-")) {
            icon =  new HyphenIcon();
        } else if (iconType.equals("<")) {
            icon =  new LessThanIcon();
        } else if (iconType.equals("@")) {
            icon =  new LoopIcon();
        } else if (iconType.equals("(") && !tab.isOpenParenthesis) {
            icon =  new OpenParenthesisIcon();
            LeftPanel.disableButtons(iconType);
        }
        return icon;
    }

}
