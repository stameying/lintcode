package EPI.Binary_Search_Tree;

import java.util.*;

/**
 * Created by stameying on 2/2/16.
 */
public class clientsCreditInfo {

    private int offset = 0;
    private Map<String,Integer> clientsToCredit = new HashMap<>();
    private NavigableMap<Integer,Set<String>> creditsToClients = new TreeMap<>();

    public void insert(String clientID, int c){
        remove(clientID);
        clientsToCredit.put(clientID,c-offset);
        Set<String> set = creditsToClients.get(c-offset);
        if (set == null){
            set = new HashSet<>();
            creditsToClients.put(c-offset,set);
        }
        set.add(clientID);
    }

    public boolean remove(String clientID){
        Integer clientCredit = clientsToCredit.get(clientID);
        if (clientCredit != null){
            creditsToClients.get(clientCredit).remove(clientID);
            if (creditsToClients.get(clientCredit).isEmpty()){
                creditsToClients.remove(clientCredit);
            }
            clientsToCredit.remove(clientID);
            return true;
        }
        return false;
    }

    public int lookup(String clientID){
        Integer clientCredit = clientsToCredit.get(clientID);
        return clientCredit==null?-1:clientCredit+offset;
    }

    public void addAll(int C){offset += C;}

    public String max(){
        return creditsToClients.isEmpty()?"":creditsToClients.lastEntry().getValue().iterator().next();
    }
}
