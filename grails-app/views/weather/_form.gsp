<%@ page import="com.weather.zipcode.Weather" %>



<div class="fieldcontain ${hasErrors(bean: weatherInstance, field: 'temperature', 'error')} required">
	<label for="temperature">
		<g:message code="weather.temperature.label" default="Temperature" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="temperature" type="number" value="${weatherInstance.temperature}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: weatherInstance, field: 'zipCode', 'error')} required">
	<label for="zipCode">
		<g:message code="weather.zipCode.label" default="Zip Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="zipCode" type="number" value="${weatherInstance.zipCode}" required=""/>

</div>

