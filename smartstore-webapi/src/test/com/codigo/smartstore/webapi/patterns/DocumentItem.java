package com.codigo.smartstore.webapi.patterns;

import java.time.Month;
import java.util.List;

public class DocumentItem {

	public static void main(final String[] args) {

		final var docItem = DocumentItem.builder()
				.title("Umowa")
				.category(DocumentCategory.of("HR"))
				.signatures(List.of("Andrzej", "Marek"))
				.build();
		System.out.println(docItem);

		final Month month = Month.APRIL;

		final var result = switch (month) {

		case JANUARY, JUNE, JULY -> 3;
		case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
		case MARCH, MAY, APRIL, AUGUST -> {

			final int monthLength = month.toString()
					.length();
			yield monthLength * 4;
		}
		default -> 0;
		};

		System.out.println(result);

	}

	private final String title;
	private final DocumentCategory category;

	private final List<String> signatures;

	private DocumentItem(final String title, final DocumentCategory category, final List<String> signatures) {

		this.title = title;
		this.category = category;
		this.signatures = signatures;
	}

	@Override
	public String toString() {

		return "DocumentItem [title=" + this.title
				+ ", category="
				+ this.category
				+ ", signatures="
				+ this.signatures
				+ "]";
	}

	public static DocumentItemBuilder builder() {

		return new DocumentItemBuilder();
	}

	static class DocumentItemBuilder {

		private String title;
		private DocumentCategory category;
		private List<String> signatures;

		DocumentItemBuilder title(final String title) {

			this.title = title;
			return this;
		}

		DocumentItemBuilder category(final DocumentCategory category) {

			this.category = category;
			return this;
		}

		DocumentItemBuilder signatures(final List<String> signatures) {

			this.signatures = signatures;
			return this;
		}

		DocumentItem build() {

			return new DocumentItem(this.title, this.category, this.signatures);
		}
	}
}

class DocumentCategory {

	private final String name;

	private DocumentCategory(final String name) {

		this.name = name;
	}

	static DocumentCategory of(final String name) {

		return new DocumentCategory(name);
	}

	@Override
	public String toString() {

		return "DocumentCategory(name=" + this.name
				+ ")";
	}
}