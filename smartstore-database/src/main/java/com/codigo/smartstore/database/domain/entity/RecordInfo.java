package com.codigo.smartstore.database.domain.entity;

import static com.codigo.smartstore.database.domain.common.DateTimeFormats.ISO_TIMESTAMP;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

enum AcceptedStates {
	A,
	O
}

enum RecordStates {
	A,
	O
}

@Embeddable
public class RecordInfo {

	@Column(name = "AcceptedState")
	private AcceptedStates acceptedState;

	private RecordStates recordState;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CreatedTimestamp")
	private Date createdTimestamp;

	@Column(name = "CreatedUser")
	private String createdUser;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "AcceptedTimestamp")
	private Date acceptedTimestamp;

	@Column(name = "AcceptedUser")
	private String acceptedUser;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CanceledTimestamp")
	private Date canceledTimestamp;

	@Column(name = "CanceledUser")
	private String canceledUser;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ModifiedTimestamp")
	private Date modifiedTimestamp;

	@Column(name = "ModifiedUser")
	private String modifiedUser;

	public AcceptedStates getAcceptedState() {

		return this.acceptedState;
	}

	public void setAcceptedState(final AcceptedStates acceptedState) {

		this.acceptedState = acceptedState;
	}

	public RecordStates getRecordState() {

		return this.recordState;
	}

	public void setRecordState(final RecordStates recordState) {

		this.recordState = recordState;
	}

	public Date getCreatedTimestamp() {

		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(final Date createdTimestamp) {

		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedUser() {

		return this.createdUser;
	}

	public void setCreatedUser(final String createdUser) {

		this.createdUser = createdUser;
	}

	public Date getAcceptedTimestamp() {

		return this.acceptedTimestamp;
	}

	public void setAcceptedTimestamp(final Date acceptedTimestamp) {

		this.acceptedTimestamp = acceptedTimestamp;
	}

	public String getAcceptedUser() {

		return this.acceptedUser;
	}

	public void setAcceptedUser(final String acceptedUser) {

		this.acceptedUser = acceptedUser;
	}

	public Date getCanceledTimestamp() {

		return this.canceledTimestamp;
	}

	public void setCanceledTimestamp(final Date canceledTimestamp) {

		this.canceledTimestamp = canceledTimestamp;
	}

	public String getCanceledUser() {

		return this.canceledUser;
	}

	public void setCanceledUser(final String canceledUser) {

		this.canceledUser = canceledUser;
	}

	public Date getModifiedTimestamp() {

		return this.modifiedTimestamp;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.acceptedState, this.acceptedTimestamp, this.acceptedUser, this.canceledTimestamp,
			this.canceledUser, this.createdTimestamp, this.createdUser, this.modifiedTimestamp, this.modifiedUser,
			this.recordState);
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;

		if (!(obj instanceof RecordInfo))
			return false;

		final RecordInfo other = (RecordInfo) obj;

		return (this.acceptedState == other.acceptedState)
				&& Objects.equals(this.acceptedTimestamp, other.acceptedTimestamp)
				&& Objects.equals(this.acceptedUser, other.acceptedUser)
				&& Objects.equals(this.canceledTimestamp, other.canceledTimestamp)
				&& Objects.equals(this.canceledUser, other.canceledUser)
				&& Objects.equals(this.createdTimestamp, other.createdTimestamp)
				&& Objects.equals(this.createdUser, other.createdUser)
				&& Objects.equals(this.modifiedTimestamp, other.modifiedTimestamp)
				&& Objects.equals(this.modifiedUser, other.modifiedUser)
				&& (this.recordState == other.recordState);
	}

	@Override
	public String toString() {

		return "RecordInfo [acceptedState=" + this.acceptedState
				+ ", recordState="
				+ this.recordState
				+ ", createdTimestamp="
				+ (this.createdTimestamp != null ? ISO_TIMESTAMP.format(this.createdTimestamp) : this.createdTimestamp)
				+ ", createdUser="
				+ this.createdUser
				+ ", acceptedTimestamp="
				+ (this.acceptedTimestamp != null
						? ISO_TIMESTAMP.format(this.acceptedTimestamp)
							: this.acceptedTimestamp)
				+ ", acceptedUser="
				+ this.acceptedUser
				+ ", canceledTimestamp="
				+ (this.canceledTimestamp != null
						? ISO_TIMESTAMP.format(this.canceledTimestamp)
							: this.canceledTimestamp)
				+ ", canceledUser="
				+ this.canceledUser
				+ ", modifiedTimestamp="
				+ (this.modifiedTimestamp != null
						? ISO_TIMESTAMP.format(this.modifiedTimestamp)
							: this.modifiedTimestamp)
				+ ", modifiedUser="
				+ this.modifiedUser
				+ "]";
	}

	public void setModifiedTimestamp(final Date modifiedTimestamp) {

		this.modifiedTimestamp = modifiedTimestamp;
	}

	public String getModifiedUser() {

		return this.modifiedUser;
	}

	public void setModifiedUser(final String modifiedUser) {

		this.modifiedUser = modifiedUser;
	}
}
