/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.antlr.works.editor.completion.AutoCompletionMenu;







public class IA {
 
   
   
   
    public IA(){
        
         
    }
       
      
         
    public static void main(String[] args) {
               
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
     
       
          
       
      
         

       

  
    }
    
    
  
    
    public static void tipoPersona(Interfaz interfaz){
        
            //carga de archivo
        String fileName = "C:\\Users\\Octavio\\Desktop\\Nueva carpeta\\avip.fcl";
        FIS fis = FIS.load(fileName,true);
        
        // Error while loading?
         if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        
        
         // para que muestre las graficas
        Variable edad = fis.getVariable("edad");
        Variable habito = fis.getVariable("habito");
        Variable tamaño = fis.getVariable("tamano");
        Variable alojamiento = fis.getVariable("alojamiento");
        Variable transporte = fis.getVariable("transporte");
        Variable sexo = fis.getVariable("sexo");
        JFuzzyChart.get().chart(fis.getFunctionBlock("avip"));
    
      
        fis.setVariable("transporte", interfaz.getTransporte());
        fis.setVariable("edad", interfaz.getEdad());
        fis.setVariable("sexo",interfaz.getSexo());
        fis.setVariable("tamano", interfaz.getCantPersonas());
        fis.setVariable("alojamiento", interfaz.getAlojamiento());
        
     
        fis.evaluate(); 
        
        //salida
        
        Variable coincidencia =  fis.getVariable("coincidencia");
        JFuzzyChart.get().chart(coincidencia, coincidencia.getDefuzzifier(), true);
        System.out.println("Output value:" + fis.getVariable("coincidencia").getValue());
        
      
        
        
        
        
        
    }
        
    
        
        
        
        
        
        //DE PRUEBA 
        
       /* 
        String fileName = "C:\\Users\\Octavio\\Desktop\\Nueva carpeta\\tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        
        Variable service = fis.getVariable("service");
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));

      
 

       // Set inputs
        fis.setVariable("service", 3);
        fis.setVariable("food", 7);

        // Evaluate
        fis.evaluate();


        // Show output variable
       
        Variable tip =  fis.getVariable("tip");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
        System.out.println("Output value:" + fis.getVariable("tip").getValue()); 
        
        

        // Print ruleSet
        //System.out.println(fis);   
       
        
        
        
   fis.setVariable("service", 3); // Set inputs
    fis.setVariable("food", 7);
    fis.evaluate(); // Evaluate
    System.out.println("Output value:" + fis.getVariable("tip").getValue()); // Show output variable

    // Show each rule (and degree of support)
    for( Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules() )
      System.out.println(r); 
        
        
      */



       
    
    
}
