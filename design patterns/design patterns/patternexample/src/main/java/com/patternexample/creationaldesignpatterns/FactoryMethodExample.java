package com.patternexample.creationaldesignpatterns;


import java.io.*;





abstract class Plan{  
         protected double rate;  
         abstract void getRate();  
   
         public void calculateBill(int units){  
              System.out.println(units*rate);  
          }  
}

class  DomesticPlan extends Plan{  
     
     public void getRate(){  
         rate=2.50;              
    }  
}

class  CommercialPlan extends Plan{  
	   
	    public void getRate(){   
	        rate=9.50;  
	   }  
	    
}

class  InstitutionalPlan extends Plan{  
	   
	    public void getRate(){   
	        rate=6.50;  
	   }   
	    
	    
}


class Plandetails{  
    
	  
	       public Plan getPlan(String planType){  
	            if(planType == null){  
	             return null;  
	            }  
	          if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
	                 return new DomesticPlan();  
	               }   
	           else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
	                return new CommercialPlan();  
	            }   
	          else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {  
	                return new InstitutionalPlan();  
	          }  
	      return null;  
	   }  
	}

class FactoryMethodExample{  
    public static void main(String args[])throws IOException{  
      Plandetails planFactory = new Plandetails();  
      
      
      System.out.print("The available plans are \nDomesticPlan\nCommercialPlan\nInstitutionalPlan\n");  
        
      System.out.print("Enter the name of plan for which the bill will be generated: ");  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
      String planName=br.readLine();  
      System.out.print("Enter the number of units for bill will be calculated: ");  
      int units=Integer.parseInt(br.readLine());  
  
      Plan p = planFactory.getPlan(planName);  
    
  
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units);  
            }  
    }


