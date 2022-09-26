public class Tips {

    private String r;       
    
    public void Tips1(Integer n){
        
        switch (n) {
            case 0:
                r = "Está perto do Moura II!";
                break;           
            case 1:
                r = "Está perto do Moura II!";
                break;
            case 2:
                r = "Está perto do Estacionamento!";
                break;           
            case 3:
                r = "Está perto do Moura II e do Estacionamento!";
                break;
            case 4: 
                r = "Está perto do Moura II e do Estacionamento!";
                break;          
            case 5:
                r = "Está perto do Estacionamento e da Quadra!";
                break;
            case 6:
                r = "Está perto do Moura II e da Quadra!";
                break;           
            case 7:
                r = "Está perto do Moura!";
                break;                   
            case 8:
                r = "Está perto da Quadra!";
                break;
                
            default:
                r = "Erro para exbir as dicas!";
                
        }
         
    }

    public String getR() {
        return r;
    }
}
