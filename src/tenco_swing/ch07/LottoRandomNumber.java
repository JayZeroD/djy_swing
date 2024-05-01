package tenco_swing.ch07;

import java.util.Arrays;
import java.util.Random;

// 클래스를 설계 --> 단일 책임 원칙을 설정하는 것이 좋다.
public class LottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;

	// 6개의 랜덤 번호를 생성하는 메서드가 필요.
	public int[] creatNumber() {

		int lottoWinNum[] = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();
		// 10
		// 10 , 20
		// 10 , 20 , 10

		for (int i = 0; i < lottoWinNum.length; i++) {
			lottoWinNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoWinNum[i] == lottoWinNum[j]) {
					lottoWinNum[i] = random.nextInt(45) + 1;
					i--;
				}

			}
		}

		Arrays.sort(lottoWinNum); // 오름차순으로 자동 정렬

		return lottoWinNum;
	}

	// 코드 테스트
	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();
		int[] resultArray = randomNumber.creatNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + "\t");
		}
	}

}
