package pl.bestapp.binancebot.client.domain;

/**
 * Order execution type.
 */
public enum ExecutionType {
  NEW,
  CANCELED,
  REPLACED,
  REJECTED,
  TRADE,
  EXPIRED
}