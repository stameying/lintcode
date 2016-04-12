package src.Google_Topic.Onsite;

import java.util.Objects;

/**
 * Created by stameying on 4/5/16.
 */
public class p313 {

    private class primeNode implements Comparable<primeNode>{
        public int val;
        public int prime;
        public int curIdx;

        public primeNode(int val, int prime, int index){
            this.val = val;
            this.prime = prime;
            this.curIdx = index;
        }

        @Override
        public int compareTo(primeNode p2){
            return Integer.compare(this.val,p2.val);
        }

        public boolean equals(Object o){
            if (o == null || !(o instanceof primeNode)) return false;
            return this==null || (this.val== ((primeNode) o).val
                    && this.prime == ((primeNode) o).prime
                    && this.curIdx == ((primeNode)o).curIdx);
        }

        public int hashCode(){
            return Objects.hash(this.val,this.prime,this.curIdx);
        }
    }


}
