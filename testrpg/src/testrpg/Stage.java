package testrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

interface Stage {	
	// 문자열 입력 - 임시정장
	public StringBuffer buffer = new StringBuffer();
	// 문자열 출력 = print랑 비슷
	public BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));
	// 입력 받기
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
}
