# algorithmhw1
This project is algorithm homework1






1.readme.txt will tell you about how to test the project


目標一：關於bogo-sort的介紹

這個演算法的名字源自Quantum bogodynamics，又稱bozo sort、blort sort或猴子排序，而他的做法是將一堆卡片拋起，落在桌上後檢查卡片是否已整齊排列好，若非就再拋一次。
作法來源：https://zh.wikipedia.org/wiki/Bogo%E6%8E%92%E5%BA%8F

目標二：

2-1. 程式碼來源 ：https://gist.github.com/pencil/1253001  
		
2-2. 成長曲線圖 ：由圖一中縱軸為時間（毫秒），橫軸為n張卡片。成長曲線看起來以指數型的方式成長，因為起初時還沒差那麼多，但從表一中在n = 9以後所花時間成長速率都不只2倍的方式做增長 （在本次作業中所有數據為跑過5次的平均）

圖一：成長曲線圖（橫軸為數入n個數字，縱軸為T(n)(單位：毫秒)）
	
![image](https://github.com/howard31622/algorithmhw1/blob/master/%E5%9C%96%E7%89%87%201.png)


表一：成長曲線圖的數值表 	

![image](https://github.com/howard31622/algorithmhw1/blob/master/表一.png)

2-3. 使用機器規格：mac pro 2016 
處理器 2GHz Intel Core i5
記憶體 8 GB 1867 MHz LPDDR3

	
目標三：bogo sort 的 
	1.best case : O(n)
在best case 的情況下，bogo sort 一次剛好是最佳的排序，再用O(n)的時間複雜度去檢查有沒有正確排序，所以時間複雜度為O(1) x O(n) = O(n)
	2.worst case : O(∞)
在worst case 的情況下，bogo sort可能都不會達成最佳的那一次，因此時間複雜度為O(∞)
	3.average case : O(n x n!)
在average case 的情況下，bogo sort 一次是最佳的排序，排列總次數為n!，因此成功的機率為(1/n!)，所以期望值為n!，檢查排序所需要的是O(n)，而最後時間複雜度為O(n!) x O(n) = O(nxn!)



目標四：自訂一個Algorithm比bogo sort爛

4-1. 自訂的演算法為howard sort ，pseudo-code 如下：
		int n1 [n]
		int n2 [n]
		shuffle(n1)
		shuffle(n2)

		while(!isBiger(n1,n2) {
			shuffle(n1)
			while(!isinorder(n1))shuffle(n2)
		}
	isinorder為是否按照順序排序
	shuffle為隨意排序


先有兩堆一樣的牌，兩副牌組先洗完一輪後，第一堆的牌看有沒有按照順序，如果沒有，就做bogo sort，接著第一堆的第一張牌跟第二堆牌的第一張牌做比較，如果第二堆的牌沒有比較大那第二堆就做拋牌在排序一次，

4-2.時間複雜度比較 
		best case是洗一次牌後第一堆按照順序排，第二堆前n-1張牌都比第一堆前n-1張牌還大，所以是O(n^2 )最佳的情況比bogo sort 差
		worst case的情況跟猴子演算法一樣是 O(∞)
		average case 的時候成功的期望值為(n! x n!)，所以時間複雜度為O(n x n! x n!)  
		所以三個case相比後，除了worst case 一樣其他跟比bogo sort都腳差

目標五：讀readme

目標六：

從圖二及表二中看得出n=7 和 n=8 中開始快速增長，在n=9雖然有測試，但是多次測試幾個晚上都不一定可以在幾個小時內跑完，尤其在n=8的時候已經跑了50分鐘，相比於原本的bogo sort，差異逐漸越大的趨勢。 

  
圖二：成長曲線圖（橫軸為數入n個數字，縱軸為T(n)(單位：毫秒)）

![image](https://github.com/howard31622/algorithmhw1/blob/master/%E5%9C%96%E7%89%87%202.png)



表二：成長曲線圖的數值表 	

![image](https://github.com/howard31622/algorithmhw1/blob/master/%E8%A1%A8%E4%BA%8C.png)



目標七：
這次作業遇到的困難蠻多的
1.	想出比bogo sort更難的
2.	做出一個讓使用者方便的GUI介面
3.	跑實驗數據，這個問題是最大的因為輸入的數字越大的時候，跑的時間是指數方式成長，尤其n = 13的時候就要等一天，花的時間會更多。


