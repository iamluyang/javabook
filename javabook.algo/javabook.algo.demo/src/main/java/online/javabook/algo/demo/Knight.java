package online.javabook.algo.demo;

import java.util.*;

public class Knight {

    private static int[][] dirs = {{-2, 1}, {-1, 2}, { 1,  2}, { 2,  1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {

        char[][] board = new char[5][4];
        board[0][0] = 'A';  board[1][0] = 'B';  board[2][0] = 'C';  board[3][0] = 'D';  board[4][0] = 'E';
        board[0][1] = 'F';  board[1][1] = 'G';  board[2][1] = 'H';  board[3][1] = 'I';  board[4][1] = 'J';
        board[0][2] = 'K';  board[1][2] = 'L';  board[2][2] = 'M';  board[3][2] = 'N';  board[4][2] = 'O';
        board[0][3] = '*';  board[1][3] = '1';  board[2][3] = '2';  board[3][3] = '3';  board[4][3] = '*';

        Knight knight = new Knight();
        Queue<Step> travel = knight.travel(board, new Step(board, 0, 0));
        for (Step step : travel) {
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

    private List<Step> nextSteps(char[][] board, Step current) {

        List<Step> steps = new ArrayList<>();
        for (int direction = 0; direction < 8; direction++) {
            int nextX = current.getX() + dirs[direction][0];
            int nextY = current.getY() + dirs[direction][1];
            Step nextStep = new Step(board, nextX, nextY);
            if(isMove(board, nextStep)) {
                steps.add(nextStep);
            }
        }
        return steps;
    }

    private boolean isMove(char[][] board, Step step) {
        return step.getX() > -1 && step.getX() < 5 &&
               step.getY() > -1 && step.getY() < 4 &&
               board[step.getX()][step.getY()] != '*';
    }
}
