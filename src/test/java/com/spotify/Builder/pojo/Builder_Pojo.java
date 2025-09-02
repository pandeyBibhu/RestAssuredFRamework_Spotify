package com.spotify.Builder.pojo;

public class Builder_Pojo {

	private String name;
	private String description;
	private boolean Public;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isPublic() {
		return Public;
	}

	private Builder_Pojo(Builder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.Public = builder.Public;
	}

	public static class Builder {
		private String name;
		private String description;
		private boolean Public;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setPublic(boolean Public) {
			this.Public = Public;
			return this;
		}

		public Builder_Pojo build() {
			
			return new Builder_Pojo(this);
		}
	}

}
