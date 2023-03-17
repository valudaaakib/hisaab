package hisab;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class UserHandler {
    
    private static Alert alert = null;
    //Method for Showning Confirmation Dialog and return Button Type wich choiced by user
     public static Optional<ButtonType> alertConfirmation(int  record, String alertType){
      
        if(alertType.equals("deleteAlert")){
           alert=new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Delete Confirmation");
           alert.setHeaderText("Total Record You want To Delete : " + record );
           alert.setContentText("Are You Sure? Do You want To Delete This Record ? ");         
        }
        return alert.showAndWait();
    }
     
     public static Optional<ButtonType> alertConfirmation(String alertType){
        
        
        if(alertType.equals("deleteAlert")){
           alert=new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Delete Confirmation");
           alert.setContentText("Are You Sure? Do You want To Delete This Record ? ");         
        }
        else if(alertType.equals("updateAlert")){
           alert=new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Update Confirmation");
           alert.setContentText("Are You Sure? Do You want To Update This Record ? ");         
        }
        return alert.showAndWait();
    }

    public static void alertInformation(String alertType) {
           
        if(alertType.equals("saveAlert")){
           alert=new Alert(Alert.AlertType.INFORMATION);
            //alert.setTitle("");
           alert.setContentText("Data Saved SuccessFull !"); 
        }
        
        if(alertType.equals("updateSuccessInfo")){
           alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
           alert.setContentText("Data Updated SuccessFull SuccessFull !"); 
        }
    }
}
