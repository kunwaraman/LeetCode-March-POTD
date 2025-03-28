import java.util.*;
/*
time complexity: O(n^2)
space complexity: O(n)  
 */

public class FindAllPossibleRecepiesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        ArrayList<String> list = new ArrayList<>();
        boolean ismake[] = new boolean[n];
        Arrays.fill(ismake,false);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(ismake[j]){
                    continue;
                }
                boolean canmake=true;
                for(String ingr:ingredients.get(j)){
                    if(!set.contains(ingr)){
                        canmake=false;
                        break;
                    }
                }
                if(canmake){
                    set.add(recipes[j]);
                    list.add(recipes[j]);
                    ismake[j]=true;
                }
            }
        }
        return list;

    }
}
