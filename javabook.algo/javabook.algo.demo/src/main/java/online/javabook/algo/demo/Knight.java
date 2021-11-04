package online.javabook.algo.demo;

import java.util.*;

public class Knight {

    private static int[][] dirs =
            {{-2, 1}, {-2, -1}, {2, 1}, {2, -1},
             {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};

    private static char[][] board = new char[][]{
            {'A', 'B','C','D','E'},
            {'F', 'G','H','I','J'},
            {'K', 'L','M','N','O'},
            {'*', '1','2','3','*'}
    };

    public static void main(String[] args) {
        Knight knight = new Knight();
        Queue<Step> track = knight.travel(board, new Step(board, 0, 0));
        for (Step step : track) {
            System.out.println(step);
        }
    }

    public Queue<Step> travel(char[][] board, Step start) {

        Stack<Step> stack = new Stack<>();
        Queue<Step> queue = new LinkedList<>();
        Map<Step, Boolean> visit = new HashMap();

        stack.add(start);
        visit.put(start, true);
        
        while (!stack.isEmpty()) {
            if(queue.size()>=10) {
                return queue;
            }

            Step currStep = stack.pop();
            List<Step> nextSteps = nextSteps(board, currStep);

            queue.add(currStep);
            for (Step nextStep : nextSteps) {
                if(!visit.containsKey(nextStep)) {
                    stack.add(nextStep);
                    visit.put(nextStep, true);
                }
            }
        }
        return queue;
    }

    private List<Step> nextSteps(char[][] board, Step currStep) {

        List<Step> steps = new ArrayList<>();
        for (int direction = 0; direction < 8; direction++) {
            int nextX = currStep.getX() + dirs[direction][0];
            int nextY = currStep.getY() + dirs[direction][1];
            Step nextStep = new Step(board, nextX, nextY);
            if(isMove(board, currStep, nextStep)) {
                steps.add(nextStep);
            }
        }
        return steps;
    }

    private boolean isMove(char[][] board, Step currStep, Step nextStep) {
        return nextStep.getX() > -1 && nextStep.getX() < 4 &&
               nextStep.getY() > -1 && nextStep.getY() < 5 &&
               board[nextStep.getX()][nextStep.getY()] != '*';
    }
}
