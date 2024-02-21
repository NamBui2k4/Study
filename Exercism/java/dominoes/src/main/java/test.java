import java.util.*;

import com.sun.net.httpserver.Filter;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Domino {
    private int left;
    private int right;
    Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    // Donmino a = new Domino(1,2);
    int getLeft() {
        return this.left;
    }

    int getRight() {
        return this.right;
    }


    @Override
    public boolean equals(Object o) {
        Domino otherDomino = (Domino) o;
        return (this.getLeft() == otherDomino.getLeft() && this.getRight() == otherDomino.getRight()) ||
                (this.getLeft() == otherDomino.getRight() && this.getRight() == otherDomino.getLeft());
        // ab == ab  || ab == ba
    }
    public boolean containPosition(int position){
        return (left == position || right == position);
    }
    public static Domino ReverseDomino(Domino a) {
        return new Domino(a.getRight(),a.getLeft());
    }
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
    @Override
    public String toString(){
        return "domino:" +(left + "," + right);
    }
}

class Dominoes {

    // kiểm tra xem dãy domino có tồn tại không
    public void checkDomino(List<Domino> DominoList) throws ChainNotFoundException {

        if (DominoList.size() == 1) // nếu dãy chỉ có 1 domino => err
            throw new ChainNotFoundException("No domino chain found.");

        // dãy domino có đặc điểm: mỗi con số trong dãy luôn có tần suất xuất hiện là số chẵn
        //  vd: 12 21 13 33 31  (3: 4 lần , 1: 4 lần, 2: 2 lần)
        List<Integer> numberInDomino = new ArrayList<>();
        for (Domino eachOne : DominoList) {
            numberInDomino.add(eachOne.getLeft());
            numberInDomino.add(eachOne.getRight());
        }
        for (int i : numberInDomino) {
            if (Collections.frequency(numberInDomino, i) % 2 != 0)
                throw new ChainNotFoundException("No domino chain found.");
        }

        // truong hop dac biet: 1-1, 2-2, 3-3 ,4-4, .....
        List<Integer> doubleNumberInDomino = new ArrayList<>();
        for(Domino eachOne : DominoList){
            doubleNumberInDomino.add(eachOne.getLeft()*10 + eachOne.getRight());
            // 1-1 ~ left-right
            // 11 = 1*10 + 1 ~ left*10 + right
        }
        boolean divisilbe = true;
        for(int i : doubleNumberInDomino){
            if(!(i%11 == 0)){ //
                // neu 11,22,33,44,... chia het cho 11 => err
                divisilbe = false;
                break;
            }
        }
        if (divisilbe) throw new ChainNotFoundException("No domino chain found.");

    }

    public List<Domino> formChain(List<Domino> DominoList) throws ChainNotFoundException,ConcurrentModificationException {
        if(DominoList.isEmpty())
            return DominoList;
        if(DominoList.size() == 1 && DominoList.get(0).getRight() == DominoList.get(0).getLeft() )
            return  DominoList;

        checkDomino(DominoList);

        List<Domino> result = new ArrayList<>();
        List<Domino> temp = new ArrayList<>();

        temp.addAll(DominoList);
        result.add(temp.get(0));
        temp.remove(0);


        do {


            for(int i = temp.size() - 1; i >= 0 ;i--) {
                Domino end = result.get(result.size() - 1);
                Domino atI = temp.get(i);
                if (atI.getLeft() == end.getRight()) {
                    result.add(atI);
                    temp.remove(i);

                } else if (atI.getRight() == end.getRight()) {
                    result.add(new Domino(atI.getRight(), atI.getLeft()));
                    temp.remove(i);
                } else{
                    continue;
                }
            }

            if(!temp.isEmpty()){
                boolean canAddToResult = temp.stream().allMatch(
                        theOthers ->  result.get(result.size() - 1).getRight() != theOthers.getRight() && result.get(result.size() - 1).getRight() != theOthers.getLeft() );
                if(canAddToResult)
                    throw new ChainNotFoundException("No domino chain found.");
            }


        } while (!temp.isEmpty());


        return result;

    }
}

public class test{
    public static void main(String args[]){
     try{
         Dominoes dominoes = new Dominoes();

         Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1),
                 new Domino(1, 1), new Domino(2, 2), new Domino(3, 3)};
         List<Domino> dominoesList = Arrays.asList(dominoesArray);
         List<Domino> result = dominoes.formChain(dominoesList);
         for(Domino a: result)
             System.out.println(a);

     }catch (ChainNotFoundException e){
         e.printStackTrace();
     }
    }
}