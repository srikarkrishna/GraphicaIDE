import icons.*;

import javax.swing.text.AbstractDocument;

public class IconBase {
    /*************************************************************************************
     *  - Method Name: getIconObject()
     *  - Input Parameters : String iconType
     *  - Return Type :Icons
     *  - Author : Srikar
     *  - Creation Date : 03/07/2021
     *  - Desc: Returns the icon object based on the string type on which it is called.
     ***************************************************************************************/
    public Icons getIconObject(String iconType, WorkingPanel tab){
        Icons icon = null;
        if (iconType.equals("||")) {
          icon =  new BarsIcon();
        } else if (iconType.equals(")") && !tab.isCloseParenthesis) {
            icon =  new CloseParenthesisIcon();
//            tab.isCloseParenthesis = true;
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
//            tab.isOpenParenthesis = true;
            LeftPanel.disableButtons(iconType);
        }
        return icon;
    }

//    public void checkOpenParenthesis(String iconType){
//        if (iconType.equals("(")){
//
//            if(!tab.isOpenParenthesis) {
//                tab.isOpenParenthesis = true;
//                icon = iconBase.getIconObject(button.getText());
//                lPanel.disableButtons(selectedIconText);
//            }
//            else {
//                icon = null;
//            }
//        }
//    }

//    public void checkCloseParenthesis(String iconType){
//
//        if (selectedIconText.equals(")")){
//            if(!tab.isCloseParenthesis) {
//                tab.isCloseParenthesis = true;
//                icon = iconBase.getIconObject(button.getText());
//                lPanel.disableButtons(selectedIconText);
//            }
//            else {
//                icon = null;
//            }
//        }
//
//    }
}
