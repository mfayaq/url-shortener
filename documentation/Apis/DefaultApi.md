# DefaultApi

All URIs are relative to *https://url_shortener*

Method | HTTP request | Description
------------- | ------------- | -------------
[**expand**](DefaultApi.md#expand) | **GET** /{shortUrl} | GET {shortUrl}
[**shrink**](DefaultApi.md#shrink) | **POST** /v1/api/shrink | Shrink the input URL


<a name="expand"></a>
# **expand**
> expand(shortUrl)

GET {shortUrl}

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shortUrl** | **String**|  | [default to null]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

<a name="shrink"></a>
# **shrink**
> inline_response_200 shrink(InlineObject)

Shrink the input URL

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **InlineObject** | [**InlineObject**](../Models/InlineObject.md)|  |

### Return type

[**inline_response_200**](../Models/inline_response_200.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

