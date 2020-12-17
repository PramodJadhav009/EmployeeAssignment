
package com.assignment.emp.common;

/**
 *
 * @author Pramod.Jadhav
 */
public enum ApplicaionExceptionErrorCodes {

  WCE_INTERNAL_SERVER_ERROR(500, "Error while processing data"), WCE_BAD_REQUEST(400,
      "Mandatory fields value should not be null"), WCE_RESOURCE_NOT_FOUND(404,
          "Requested resource not found"), WCE_DATA_NOT_MATCH(405,
              "Data do not match"), WCE_TOO_MANY_REQUESTS(429,
                  "Too many requests"), WCE_DB_DATA_DUPLICATE(1003,
                      "Data already exists in system"), WCE_PROCESSING_DATA_FAILED(1002,
                          "Processing data failed"), WCE_BAD_ACTION(1004, "Bad Action Request");

  private int errorCode;
  private String description;

  ApplicaionExceptionErrorCodes(final int errorCode, final String description) {
    this.errorCode = errorCode;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public int getErrorCode() {
    return errorCode;
  }

  void setDescription(final String description) {
    this.description = description;
  }

  void setErrorCode(final int errorCode) {
    this.errorCode = errorCode;
  }
}
