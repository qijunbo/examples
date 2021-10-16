package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
0 9 5 0 2 0 0 6 0
0 0 7 1 0 3 9 0 2
6 0 0 0 0 5 3 0 4
0 4 0 0 1 0 6 0 7
5 0 0 2 0 7 0 0 9
7 0 3 0 9 0 0 2 0
0 0 9 8 0 0 0 0 6
8 0 6 3 0 2 1 0 5
0 5 0 0 7 0 2 8 3
--------------------------------
0 0 8 7 1 9 2 4 5
9 0 5 2 3 4 0 8 6
0 7 4 8 0 6 1 0 3
7 0 3 0 9 2 0 0 0
5 0 0 0 0 0 0 0 0
8 6 1 4 0 3 5 2 9
4 0 0 0 2 0 0 0 8
0 0 0 0 0 0 0 7 0
1 0 7 0 6 8 0 5 0
 * @author qijunbo
 *
 */
public class Sudu {
	static class P {
		public int x;
		public int y;

		public P(int x, int y) {

			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "P [x=" + x + ", y=" + y + "]";
		}

	}

	public static char[] shrink(String str) {
		char[] result = new char[9];
		for (int i = 0, j = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result[j++] = str.charAt(i);
			}
		}
		return result;
	}

	public static void print(char[][] sudu) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudu[i][j]);
				if (j < 8) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static List<P> check(char[][] sudu) {
		List<P> todo = new LinkedList<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudu[i][j] == '0') {
					todo.add(new P(i, j));
				}
			}
		}
		return todo;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] sudu = new char[9][9];
		for (int i = 0; i < 9; i++) {
			sudu[i] = shrink(sc.nextLine());
		}

		List stack = new ArrayList();
		stack.add(sudu);
		while (stack.size() > 0)
			find(stack);
	}

	private static void find(List stack) {

		char[][] sudu = null;

		if (stack.size() > 0) {
			sudu = (char[][]) stack.get(0);
			stack.remove(0);
		}

		List<P> done = new ArrayList<>();
		List<P> todo = check(sudu);
		boolean dfs = false;
		while (todo.size() > 0) {
			int count = todo.size();
			for (P p : todo) {
				int x = p.x;
				int y = p.y;
				List<Character> answer = new ArrayList<Character>(
						Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
				for (int i = 0; i < 9; i++) {
					// ˮƽ�ų�, sudu �ĵ�x��, ���г��ֹ�������
					if (answer.contains(sudu[x][i]))
						answer.remove(new Character(sudu[x][i]));
					// ��ֱ�ų�, sudu �ĵ�y��, ���г��ֹ�������
					if (answer.contains(sudu[i][y]))
						answer.remove(new Character(sudu[i][y]));
				}

				if (answer.size() == 1) {
					// �����Ψһ��, ������.
					sudu[x][y] = answer.get(0);
					done.add(p);
					continue;
				}

				// x, y ���ڵľŹ���������ֵ������ų���.
				int row = x / 3;
				int col = y / 3;

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (answer.contains(sudu[row * 3 + i][col * 3 + j]))
							answer.remove(new Character(sudu[row * 3 + i][col * 3 + j]));
					}
				}
				if (answer.size() == 0) {
					// TODO ʧ����.
					System.out.println("========ʧ��========");
					print(sudu);
					break;
				}

				if (answer.size() == 1) {
					// �����Ψһ��, ������.
					sudu[x][y] = answer.get(0);
					done.add(p);
					continue;
				}

				if (dfs && answer.size() > 1) {
					// ��һ������, �ֽ�� answer.size() ������, �ֱ����.
					for (Character c : answer) {
						char[][] b = new char[9][9];
						System.arraycopy(sudu, 0, b, 0, 9);
						b[x][y] = c; // answer�����ÿһ������ֵ��������һ��ƽ������.
						stack.add(0, b);
					}
					return;
				}

			}

			todo.removeAll(done);
			if (todo.size() == 0) {
				print(sudu);
				System.out.println("========Success========");
				break;
			}
			if (todo.size() < count) {
				continue;
			}

			// һ�ٲ�������, ����һ��û�м���.
			if (todo.size() == count) {
				dfs = true;
			}
		}
	}

}
