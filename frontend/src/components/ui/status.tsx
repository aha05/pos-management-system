export const Status = ({ value }: { value: string }) => {
  return (
    <span className={`status status-${value.toLowerCase()}`}>
      <span />
      {value}
    </span>
  );
}