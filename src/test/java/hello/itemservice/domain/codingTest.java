package hello.itemservice.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class codingTest {

    @Test
    void mainTest() {

        int N = 7;
        int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
        String[] dirname= {"root","adcd","cs","hello","ect","hello","solution"};

        solution(N, relation, dirname);


    }

    //세번째 문제
    public int solution(int N, int[][] relation, String[] dirname) {
        int answer = 0;

        //Map<Integer, String> node = new HashMap<>();
        String result = "";
        String temp = "";

        //두번째 번호가 이어 연결되는 부분 찾도록하기
        for (int i = 0; i < N-1; i++) {
            temp = selectNode(N-1, relation, relation[i][1], dirname, "");
            if(result.length() < temp.length()){
                result = temp;
            }
        }

        return ("root" + result).length();
    }


    public String selectNode(int N, int[][] relation, int secondeNum , String[] dirname, String resultParam) {

        //현재까지의 경로
        String paramStr = resultParam + "/" + dirname[secondeNum-1] ;
        //자식 노드의 리턴 값
        String result = "";
        //비교값
        String compareStr = "";

        for (int i = 0; i < N; i++) {

            //연결되는 지점이 있을 때까지 찾음
            if (relation[i][0] == secondeNum) {

                compareStr = selectNode(N, relation, relation[i][1], dirname, paramStr);

                if (compareStr.length() > result.length()) {
                    result = compareStr;
                }
            }
        }

        return result.equals("") ? paramStr : result;
    }



      //두번째 문제
    /*public int[] solution(int[] grade) {
        //int[] answer = {};
        int[] answer = new int[grade.length];

        Map<Integer,Integer> compareMap = new HashMap();


        for (int i : grade) {

            if(compareMap.get(i) == null){
                compareMap.put(i,1);
            }else{
                compareMap.put(i, (compareMap.get(i) + 1));
            }
        }

        List<Integer> keyList = new ArrayList<>(compareMap.keySet());

        int rank = 0;
        int temp = 0;
        for (int i = keyList.size()-1 ; i >= 0; i--) {

            if(rank == 0){
                rank += compareMap.get(keyList.get(i)) + 1;
                compareMap.put(keyList.get(i), 1);
            }else{
                temp = compareMap.get(keyList.get(i)) ;
                compareMap.put(keyList.get(i), rank);
                //rank += compareMap.get(keyList.get(i)) ;

                rank += temp ;
            }
        }

        for (int i=0 ; i < grade.length ; i++) {
            answer[i] = compareMap.get(grade[i]);
        }



        return answer;
    }*/






    //네번째 문제?
    /*public int solution(int[] p) {
        int answer = 0;
        int compare = -1;
        int cnt = -1;

        Arrays.sort(p);

        Map<Integer, Integer> duplList = new HashMap<>();

        for (int i : p) {

            if(duplList.get(i)== null){
                duplList.put(i, 1);
            }else{
                duplList.put(i, duplList.get(i)+1);
            }


            if(compare < i) {
                compare = i;
                answer++;
            }
        }

        while (cnt != 0) {
            cnt = selectDupl(duplList);
            if (cnt != 0) {
                answer += cnt-1;
            }
        }

        return answer;
    }*/

    public int selectDupl(Map<Integer, Integer> duplList) {
        int result = 0;
        Integer current = 0;
        Iterator<Integer> keys = duplList.keySet().iterator();


        while (keys.hasNext()) {
            current = keys.next();
            if(duplList.get(current) != 1){
                duplList.put(current  , (duplList.get(current) - 1));
                result++;
            }
        }

        return result;

    }












    //첫번째 문제
    /*public String solution(int num) {
        String[] numStr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String answer = "";

        String[] paramStr = String.valueOf(num).split("");

        for (String i : paramStr) {
            answer += numStr[Integer.valueOf(i)];
        }
        return answer;
    }*/
}
