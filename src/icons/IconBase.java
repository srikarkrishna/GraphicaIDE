package icons;

public class IconBase {
    /*************************************************************************************
     *  - Method Name: getIconObject()
     *  - Input Parameters : String iconType
     *  - Return Type :Icons
     *  - Author : Srikar
     *  - Creation Date : 03/07/2021
     *  - Desc: Returns the icon object based on the string type on which it is called.
     ***************************************************************************************/
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
        } else if (iconType.equals("(")) {
            icon =  new OpenParenthesisIcon();
        }
        return icon;
    }
}
