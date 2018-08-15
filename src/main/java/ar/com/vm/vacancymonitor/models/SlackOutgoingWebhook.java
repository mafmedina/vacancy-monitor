package ar.com.vm.vacancymonitor.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "token", "team_id", "team_domain", "channel_id", "channel_name", "timestamp",
		"user_id", "user_name", "text", "trigger_word" })
public class SlackOutgoingWebhook implements Serializable {

	private static final long serialVersionUID = -9093772448037035559L;

	@JsonProperty("token")
	private String token;

	@JsonProperty("team_id")
	private String teamId;

	@JsonProperty("team_domain")
	private String teamDomain;

	@JsonProperty("channel_id")
	private String channelId;

	@JsonProperty("channel_name")
	private String channelName;

	//@JsonProperty("thread_ts")
	//private String threadTS;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("text")
	private String text;

	@JsonProperty("trigger_word")
	private String triggerWord;

	public SlackOutgoingWebhook() {
	};

	public SlackOutgoingWebhook(String token, String teamId, String teamDomain, String channelId, String channelName,
			//String threadTS,
			String timestamp, String userId, String userName, String text, String triggerWord) {
		super();
		this.token = token;
		this.teamId = teamId;
		this.teamDomain = teamDomain;
		this.channelId = channelId;
		this.channelName = channelName;
		//this.threadTS = threadTS;
		this.timestamp = timestamp;
		this.userId = userId;
		this.userName = userName;
		this.text = text;
		this.triggerWord = triggerWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + ((teamDomain == null) ? 0 : teamDomain.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((triggerWord == null) ? 0 : triggerWord.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SlackOutgoingWebhook other = (SlackOutgoingWebhook) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (teamDomain == null) {
			if (other.teamDomain != null)
				return false;
		} else if (!teamDomain.equals(other.teamDomain))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (triggerWord == null) {
			if (other.triggerWord != null)
				return false;
		} else if (!triggerWord.equals(other.triggerWord))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@JsonProperty("token")
	public String getToken() {
		return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("team_id")
	public String getTeamId() {
		return teamId;
	}

	@JsonProperty("team_id")
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@JsonProperty("team_domain")
	public String getTeamDomain() {
		return teamDomain;
	}

	@JsonProperty("team_domain")
	public void setTeamDomain(String teamDomain) {
		this.teamDomain = teamDomain;
	}

	@JsonProperty("channel_id")
	public String getChannelId() {
		return channelId;
	}

	@JsonProperty("channel_id")
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@JsonProperty("channel_name")
	public String getChannelName() {
		return channelName;
	}

	@JsonProperty("channel_name")
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	//@JsonProperty("thread_ts")
	//public String getThreadTS() {
	//	return threadTS;
	//}

	//@JsonProperty("thread_ts")
	//public void setThreadTS(String threadTS) {
	//	this.threadTS = threadTS;
	//}

	@JsonProperty("user_id")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("user_id")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("user_name")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("user_name")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("trigger_word")
	public String getTriggerWord() {
		return triggerWord;
	}

	@JsonProperty("trigger_word")
	public void setTriggerWord(String triggerWord) {
		this.triggerWord = triggerWord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
