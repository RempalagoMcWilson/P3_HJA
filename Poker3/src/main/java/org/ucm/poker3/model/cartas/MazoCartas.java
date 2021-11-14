
package org.ucm.poker3.model.cartas;

public class MazoCartas {
    private Boolean[][] mazo;
    public MazoCartas(){
        reset();
    }

    public Boolean[][] getMazo() {
        return mazo;
    }
    
    public void meteCarta(int i, int j){
        mazo[i][j] = true;
    }
    public void quitaCarta(int i, int j){
        mazo[i][j] = false;
    }
    public Boolean isCarta(int i, int j){
        return mazo[i][j];
    }
    public void reset(){
        mazo = new Boolean[13][4];
        for(int i= 0; i< 13;i++){
            for(int j=0; j<4;j++){
                mazo[i][j] = false;
            }
        }
    }
}
