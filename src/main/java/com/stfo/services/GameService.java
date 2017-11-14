package com.stfo.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stfo.helper.Constants;
import com.stfo.models.CasinoTableModel;
import com.stfo.models.UserModel;
import com.stfo.models.requestModels.GameRequestModel;
import com.stfo.models.responseModels.GameResultResponseModel;

@Service
public class GameService {

	@Autowired
	private UserService userService;

	public GameResultResponseModel getResult(GameRequestModel model) {
		GameResultResponseModel result = new GameResultResponseModel();
		Long userId = model.getUserId();
		UserModel user = this.userService.getUser(userId);

		CasinoTableModel table = model.getCasinoTable();
		BigDecimal amountBetted = new BigDecimal(table.calculateBettingAmount());

		if (user.getBalanceAmount().compareTo(amountBetted) >= 0) {
			this.userService.blockAmount(userId, amountBetted);
			int randomNumber = Constants.getRandomNumber();
			BigDecimal amountWon = this.getResult(table.getNumbers(), randomNumber);
			this.userService.removeBlockingAmount(userId, amountBetted);
			this.userService.addBalance(userId, amountWon);
			result.setRandomNumber(randomNumber);
			result.setAmountBetted(amountBetted);
			result.setAmountWon(amountWon);
			return result;
		} else {
			return result;
		}
	}

	private BigDecimal getResult(Long[] bets, int randomNumber) {
		BigDecimal won = new BigDecimal("0");
		BigDecimal base = new BigDecimal(Constants.BETTING_UNIT);
		// 0
		if (randomNumber == 0) {
			won = won.add(Constants.multipliers[Constants.iZERO].multiply(new BigDecimal(bets[Constants.iZERO])));
		}

		if (randomNumber > 0 && randomNumber <= 12) {
			won = won.add(Constants.multipliers[Constants.iFIRST_TWELVE]
					.multiply(new BigDecimal(bets[Constants.iFIRST_TWELVE]))
					.multiply(base));
		}

		if (randomNumber > 12 && randomNumber <= 24) {
			won = won.add(Constants.multipliers[Constants.iSECOND_TWELVE]
					.multiply(new BigDecimal(bets[Constants.iSECOND_TWELVE]))
					.multiply(base));
		}

		if (randomNumber > 24 && randomNumber <= 36) {
			won = won.add(Constants.multipliers[Constants.iTHIRD_TWELVE]
					.multiply(new BigDecimal(bets[Constants.iTHIRD_TWELVE]))
					.multiply(base));
		}

		if (randomNumber > 0 && randomNumber <= 18) {
			won = won.add(Constants.multipliers[Constants.iFIRST_EIGHTEEN]
					.multiply(new BigDecimal(bets[Constants.iFIRST_EIGHTEEN]))
					.multiply(base));
		}

		if (randomNumber > 18 && randomNumber <= 36) {
			won = won.add(Constants.multipliers[Constants.iLAST_EIGHTEEN]
					.multiply(new BigDecimal(bets[Constants.iLAST_EIGHTEEN]))
					.multiply(base));
		}

		if (randomNumber != 0 && randomNumber % 2 == 0) {
			won = won.add(
					Constants.multipliers[Constants.iEVEN]
					.multiply(new BigDecimal(bets[Constants.iEVEN]))
					.multiply(base));
		}

		if (randomNumber % 2 != 0) {
			won = won.add(Constants.multipliers[Constants.iODD]
					.multiply(new BigDecimal(bets[Constants.iODD]))
					.multiply(base));
		}

		return won;
	}
}
