package de.hizr.poe.itemindexer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hizr
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicStashTabs {

	@JsonProperty("next_change_id")
	private String nextChangeId;

	private List<Stash> stashes;

	public String getNextChangeId() {
		return nextChangeId;
	}

	public void setNextChangeId(final String nextChangeId) {
		this.nextChangeId = nextChangeId;
	}

	public List<Stash> getStashes() {
		return stashes;
	}

	public void setStashes(final List<Stash> stashes) {
		this.stashes = stashes;
	}

	@Override
	public String toString() {
		return "PublicStashTabs [nextChangeId=" + nextChangeId + ", stashes=" + stashes + "]";
	}

}
