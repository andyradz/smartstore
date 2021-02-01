// package com.codigo.smartstore.webapi;
//
// import java.util.Objects;
//
// import org.assertj.core.api.AbstractAssert;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
//
// class PageableAssert
// extends
// AbstractAssert<PageableAssert, Pageable> {
//
// PageableAssert(final Pageable pageable) {
//
// super(pageable, PageableAssert.class);
// }
//
// static PageableAssert assertThat(final Pageable actual) {
//
// return new PageableAssert(
// actual);
// }
//
// PageableAssert hasPageSize(final int expectedPageSize) {
//
// if (!Objects.equals(this.actual.getPageSize(), expectedPageSize))
// this.failWithMessage(
// "expected page size to be <%s> but was <%s>",
// expectedPageSize,
// this.actual.getPageSize());
// return this;
// }
//
// PageableAssert hasPageNumber(final int expectedPageNumber) {
//
// if (!Objects.equals(this.actual.getPageNumber(), expectedPageNumber))
// this.failWithMessage(
// "expected page number to be <%s> but was <%s>",
// expectedPageNumber,
// this.actual.getPageNumber());
// return this;
// }
//
// PageableAssert hasSort(final String field, final Sort.Direction direction) {
//
// final var actualOrder = this.actual.getSort()
// .getOrderFor(field);
//
// if (actualOrder == null)
// this.failWithMessage("expected sort for field <%s> to be <%s> but was null",
// field, direction);
// else if (actualOrder.getDirection() != direction)
// this.failWithMessage(
// "expected sort for field <%s> to be <%s> but was <%s>",
// field,
// direction,
// actualOrder.getDirection());
//
// return this;
// }
// }