package com.prodian.sr.scoringacademy.admindashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prodian.sr.scoringacademy.admindashboard.dto.CricketMatchDetailsDto;
import com.prodian.sr.scoringacademy.admindashboard.dto.CricketMatchDetailsRequestDto;
import com.prodian.sr.scoringacademy.admindashboard.dto.PlayingElevenRequestDto;
import com.prodian.sr.scoringacademy.admindashboard.dto.ResultResponse;
import com.prodian.sr.scoringacademy.admindashboard.dto.TeamMasterRequestDto;
import com.prodian.sr.scoringacademy.admindashboard.dto.UpdatePlayerIsSubstituteRequsetDto;
import com.prodian.sr.scoringacademy.admindashboard.dto.UpdateTossRequestDto;
import com.prodian.sr.scoringacademy.admindashboard.entity.CricketMatchDetailsEntity;
import com.prodian.sr.scoringacademy.admindashboard.entity.TeamMasterEntity;
import com.prodian.sr.scoringacademy.admindashboard.service.AdminDashBoardService;

@RestController
@CrossOrigin(origins = "*")
public class AdminDashBoardController {
	@Autowired
	AdminDashBoardService adminDashBoardService;

	/*
	 * Author:Harish EDDE Date 19-july-2023 pupose of api get Admin match details by
	 * passing from and to date and match ids and event names
	 */
	@PostMapping("/getAdminMatchDetails")
	public ResultResponse getAdminMatchDetails(@RequestBody CricketMatchDetailsRequestDto cricketMatchDetailsDto) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getAdminMatchDetails(cricketMatchDetailsDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish EDDE, Date 20-July-2023, Purpose of API GetTeamDetails By List
	 * OF Passing Both TeamIds And TeamNames and also Get Data By individual Team Id
	 * and TeamName
	 */
	@PostMapping("/getTeamDetailsByTeamIdAndTeamName")
	public ResultResponse getTeamDetailsByTeamIdAndTeamName(@RequestBody TeamMasterRequestDto teamMasterRequestDto) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getTeamDetailsByTeamIdAndTeamName(teamMasterRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde. Date:20-july-2023. purpose api
	 * getPlayingElevenByTeamIdAdmin of Cricket Match Details By Team Id One And
	 * Team Id Two.
	 */
	@GetMapping("/getPlayingElevenByTeamIdAdmin")
	public ResultResponse getPlayingElevenByTeamIdAdmin(@RequestParam(name = "teamOneId") String teamOneId,
			@RequestParam(name = "teamtwoId") String teamTwoId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getPlayingElevenByTeamIdAdmin(teamOneId, teamTwoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde. Date:20-july-2023. purpose api :get MatchDetails Admin By
	 * MatchId.
	 */
	@GetMapping("/getMatchDetailsAdminByMatchId")
	public ResultResponse getMatchDetailsAdminByMatchId(@RequestParam(name = "matchId") Long matchId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getMatchDetailsAdminByMatchId(matchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:20-july-2023 purpose api
	 * getAllCricketMatchDetailsAdmin
	 */
	@GetMapping("/getMatchDetailsAdminDashBoard")
	public ResultResponse getMatchDetailsAdminDashboard() {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getMatchDetailsAdminDashboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde. Date:20-july-2023. purpose API:Update Match Details In
	 * CricketMatch Details And CricketMatch Summaery By Existing MatchId.
	 */
	@PutMapping("/updateMatchDetailsAdminByMatchId")
	public ResultResponse updateMatchDetailsAdmin(@RequestBody CricketMatchDetailsDto cricketMatchDetailsDto) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updateMatchDetailsAdmin(cricketMatchDetailsDto);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus("FAILED");
			result.setMessage("Error occurred while updating match details");
		}
		return result;
	}

	/*
	 * Author:Harish Edde. Date:20-july-2023. purpose Api:Update UserMaster
	 * FirstName And LastName By UserId.
	 */
	@PutMapping("/updatePlayingElevenPlayernameAdmin")
	public ResultResponse updatePlayingElevenPlayernameAdmin(
			@RequestBody PlayingElevenRequestDto playingElevenRequestDto) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updatePlayingElevenPlayernameAdmin(playingElevenRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde. Date:20-july-2023. purpose
	 * Api:getCricketTeamPlayingElevenByMatchId.
	 */
	@GetMapping("/getCricketTeamPlayingElevenByMatchId")
	public ResultResponse getCricketTeamPlayingElevenByMatchId(@RequestParam(name = "matchId") String matchId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getCricketTeamPlayingElevenByMatchId(matchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:27-july-2023 purpose api get All Matches Details
	 * Count.
	 */
	@GetMapping("/getAllMatchDetailsCount")
	public ResultResponse getAllMatchDetailsCount() {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getAllMatchDetailsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	/*
	 * Author:Harish Edde Date:28-july-2023 purpose api get All Player Matches stats
	 * match Details with stats By existing user Id .
	 */
	@GetMapping("/getPlayerStatsMatchDetailsByUserId/{userId}")
	public ResultResponse getPlayerStatsMatchDetailsByUserId(@PathVariable Long userId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getPlayerStatsMatchDetailsByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:02-Aug-2023 purpose update Toss Detls In Match
	 * Summary By MatchId
	 */
	@PostMapping("/updateTossDetlsInMatchSummaryByMatchId")
	public ResultResponse updateTossDetlsInMatchSummaryByMatchId(
			@RequestBody UpdateTossRequestDto updateTossRequestDto) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updateTossDetlsInMatchSummaryByMatchId(updateTossRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:10-Aug-2023 purpose api Update Player Details Is
	 * Substitute or Not
	 */
	@PostMapping("/updatePlayerIsSubstituteOrNot")
	public ResultResponse updatePlayerIsSubstituteOrNot(@RequestBody UpdatePlayerIsSubstituteRequsetDto request) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updatePlayerIsSubstituteOrNot(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:11-Aug-2023 purpose api Get Team Details By Team Id.
	 */
	@GetMapping("/getTeamDetailsByTeamId")
	public ResultResponse getTeamDetailsByTeamId(@RequestParam String teamId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getTeamDetailsByTeamId(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:11-Aug-2023 purpose api get Team Details By existed
	 * Team Names with letters either caps or small.
	 */
	@GetMapping("/getSearchMembersAdminByTeamName")
	public ResultResponse getSearchMembersAdminByTeamName(@RequestParam String teamName) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getSearchMembersAdminByTeamName(teamName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:14-Aug-2023, purpose api get All Player Matches
	 * Details By user Id .
	 */
	@GetMapping("/getPlayerMatchDetailsByUserId")
	public ResultResponse getPlayerMatchDetailsByUserId(@RequestParam Long userId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getPlayerMatchDetailsByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:17-Aug-2023, purpose api get List of TeamIds And Team
	 * Names By Team Names
	 */
	@GetMapping("/getTeamIdAndTeamNameByTeamName")
	public ResultResponse getTeamIdAndTeamNameByTeamName(@RequestParam String teamName) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getTeamIdAndTeamNameByTeamName(teamName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:17-Aug-2023, purpose api get team id,team name,team
	 * email,team desc by passing list of Team Names
	 */
	@PostMapping("/getSearchTeamNameAdmin")
	public ResultResponse getSearchTeamNameAdmin(@RequestBody List<String> teamNames) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getSearchTeamNameAdmin(teamNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:18-Aug-2023, purpose api to get team player details
	 * as username,userid,path to pic by passing TeamId.s
	 */
	@GetMapping("/getPlayersDetailsByTeamId")
	public ResultResponse getPlayersByTeamId(@RequestParam String teamId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getPlayersByTeamId(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:12-Sep-2023, purpose api to get cricket match details
	 * by event Id
	 * 
	 */
	@GetMapping("/getCricketMatchDetailsByEventId")
	public ResultResponse getCricketMatchDetailsByEventId(@RequestParam String eventId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getCricketMatchDetailsByEventId(eventId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:12-Sep-2023, purpose api to get cricket match details
	 * by SportsSubCatId
	 * 
	 */
	@GetMapping("/getCricketMatchDetailsBysportsSubcatId")
	public ResultResponse getCricketMatchDetailsBysportsSubcatId(@RequestParam Integer sportsSubcatId) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.getCricketMatchDetailsBySubCatId(sportsSubcatId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:12-Sep-2023, purpose api to update All cricket match
	 * details by matchId
	 */
	@PutMapping("/updateAllCricketMatchDetailsByMatchId")
	public ResultResponse updateAllCricketMatchDetailsByMatchId(@RequestBody CricketMatchDetailsEntity request) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updateAllCricketMatchDetailsByMatchId(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:13-Sep-2023, purpose api to cricket cricket match
	 * details
	 */
	@PostMapping("/createCricketMatchDetails")
	public ResultResponse createCricketMatchDetails(@RequestBody CricketMatchDetailsEntity request) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.createCricketMatchDetails(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:13-Sep-2023, purpose api to Create Team details
	 */
	@PostMapping("/createTeamDetails")
	public ResultResponse createTeamDetails(@RequestBody TeamMasterEntity request) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.createTeamDetails(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Author:Harish Edde Date:13-Sep-2023, purpose api to Update Team Match Details
	 * By Team Id
	 */
	@PutMapping("/updateTeamDetailsByTeamId")
	public ResultResponse updateTeamDetailsByTeamId(@RequestBody TeamMasterEntity request) {
		ResultResponse result = new ResultResponse();
		try {
			result = adminDashBoardService.updateTeamDetailsByTeamId(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
